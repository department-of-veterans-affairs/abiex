package gov.va.vinci.abi.listeners;

import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.listener.BaseDatabaseListener;
import gov.va.vinci.leo.model.DatabaseConnectionInformation;
import gov.va.vinci.leo.tools.LeoUtils;
import org.apache.log4j.Logger;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.jcas.tcas.Annotation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbiDatabaseListener extends BaseDatabaseListener {

  private static final Logger log = Logger.getLogger(LeoUtils.getRuntimeClass().toString());
  public String createStatement;
  protected HashMap<String, Integer> fields = new HashMap<String, Integer>();
  protected ArrayList<String> headers = new ArrayList<String>();

  /**
   Main constructor

   @param databaseConnectionInformation
   @param preparedStatementSQL
   @param batchSize
   @param validateConnectionEachBatch
   @param createStatement                */
  public AbiDatabaseListener(
      DatabaseConnectionInformation databaseConnectionInformation,
      String preparedStatementSQL, int batchSize, boolean validateConnectionEachBatch, String createStatement,
      ArrayList<ArrayList<String>> fieldList) {
    super(databaseConnectionInformation, preparedStatementSQL);
    this.createStatement = createStatement;
    this.setHeaders(fieldList);
    //  this.fieldList = fieldList;
    // this.inputType = inTypes;
    // this.dbsName = dbsName;
    // this.outTableName = tableName;
    setBatchSize(batchSize);
    setValidateConnectionEachBatch(validateConnectionEachBatch);
  }

  /**
   This method creates a DbsListener object and initializes createStatement

   @param dbsName
   @param tableName
   @param batchSize
   @param fieldList fieldList [["TIUDocumentSID","0","bigint"]]
   @return
   */
  public static AbiDatabaseListener createNewListener(
      String driver, String url, String dbUser, String dbPwd,
      String dbsName, String tableName, int batchSize,
      ArrayList<ArrayList<String>> fieldList) {

    DatabaseConnectionInformation databaseConnectionInformation = new DatabaseConnectionInformation(
        driver, url, dbUser, dbPwd);

    String createStatement = createCreateStatement(dbsName, tableName, fieldList);
    String insertStatement = createInsertStatement(dbsName, tableName, fieldList);
    boolean validateConnectionEachBatch = true;
    return new AbiDatabaseListener(databaseConnectionInformation, insertStatement,
        batchSize, validateConnectionEachBatch, createStatement, fieldList);
  }

  /**
   Static method to create insert statement based on the database and table
   name

   @param dbsName
   @param tableName
   @param fieldList
   @return
   */
  public static String createInsertStatement(String dbsName,
                                             String tableName, ArrayList<ArrayList<String>> fieldList) {
    String statement = "INSERT INTO " + dbsName + "." + tableName + " ( ";
    String values = "";
    for (ArrayList<String> entry : fieldList) {
      statement = statement + entry.get(0) + ", ";
      values = values + " ?,";
    }
    statement = statement.substring(0, statement.length() - 2)
        + " ) VALUES ( " + values.substring(0, values.length() - 1)
        + " ) ;";
    log.info(statement);
    return statement;
  }

  /**
   Static method to create a table create statement based on the database
   and table name and list of fields

   @param dbsName
   @param tableName
   @param fieldList
   @return
   */
  public static String createCreateStatement(String dbsName,
                                             String tableName, ArrayList<ArrayList<String>> fieldList) {

    String statement = "CREATE TABLE " + dbsName + "." + tableName + " ( ";

    for (ArrayList<String> entry : fieldList) {
      statement = statement + entry.get(0) + " " + entry.get(2) + ", ";
    }
    statement = statement.substring(0, (statement.length() - 2)) + " ) ;";
    return statement;
  }

  @Override
  protected List<Object[]> getRows(CAS aCas) {
    ArrayList<Object[]> rows = new ArrayList<Object[]>();
    ArrayList<HashMap<String, String>> rowsMap = getDocumentRows(aCas);

    for (HashMap<String, String> rowMap : rowsMap) {
      // populate an ordered list of values for each column
      ArrayList<String> rowList = new ArrayList<String>();

      for (String column : headers) {
        if (rowMap.containsKey(column)) {
          rowList.add(rowMap.get(column));
        } else {
          rowList.add("");
        }
      }
      rows.add(rowList.toArray(new String[rowList.size()]));
    }
    return rows;
  }

  public void createTable(String createStatement, boolean dropFirst, String tableName) throws ClassNotFoundException,
      SQLException, InstantiationException, IllegalAccessException {
    super.createTable(createStatement, dropFirst, tableName);

    //        conn.createStatement().execute(createStatement);

  }

  protected ArrayList<HashMap<String, String>> getDocumentRows(CAS aCas) {
    String docId = this.docInfo.getID();

    String patientId = "";
    if(this.docInfo.getRowData() != null)
    if (this.docInfo.getRowData().size() > 2)
      patientId = this.docInfo.getRowData(2);

    ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();
    try {
      ArrayList<Annotation> logicList = (ArrayList<Annotation>)
          AnnotationLibrarian.getAllAnnotationsOfType(aCas.getJCas(), gov.va.vinci.abi.types.Logic.type, false);
      for (Annotation an : logicList) {
        int start = an.getBegin() - 100;
        int end = an.getEnd() + 100;
        if (start < 0)
          start = 0;
        if (end >= aCas.getDocumentText().length())
          end = aCas.getDocumentText().length() - 1;


        String value = ((gov.va.vinci.abi.types.Logic) an).getABI_Value();
        String laterality_value = ((gov.va.vinci.abi.types.Logic) an).getLaterality_Value();
        String anatomy_value = ((gov.va.vinci.abi.types.Logic) an).getAnatomy_Value();
        String document_value = ((gov.va.vinci.abi.types.Logic) an).getDocument_Date();
        String index_value = ((gov.va.vinci.abi.types.Logic) an).getIndex_Type();
        String pattern = ((gov.va.vinci.abi.types.Logic) an).getCoveredText();
        //Used to debug
       // String snippet = "--------------------\r\n-----START-----\r\n--------------------\r\n" + aCas.getDocumentText().substring(start, end) + "\r\n--------------------\r\n-----END-----\r\n--------------------";
        String snippet =  aCas.getDocumentText().substring(start, end);
        String snipStart = "" + an.getBegin();
        String snipEnd = "" + an.getEnd();
        HashMap<String, String> record = new HashMap<String, String>();
        for (Map.Entry<String, Integer> item : fields.entrySet()) {
          try {
            if (item.getValue() > 0) {
              if (this.docInfo.getRowData().size() > item.getValue()) {

                record.put(item.getKey(), this.docInfo.getRowData(item.getValue()));
              }
            }
          } catch (Exception e) {
            record.put(item.getKey(), "");
          }
        }
        record.put("DocID", docId);
        record.put("PatientSID", patientId);
        record.put("Index_Value", value);
        record.put("Index_Type", index_value);
        record.put("Laterality_Value", laterality_value);
        record.put("Anatomy_;Value", anatomy_value);
        record.put("ABIPattern", pattern);
        record.put("Document_Date", document_value);
        record.put("Snippet", snippet);
        record.put("SpanStart", snipStart);
        record.put("SpanEnd", snipEnd);


        rows.add(record);
      }

    } catch (CASException ex) {
      ex.printStackTrace();
    }

    return rows;
  }

  /**
   @param fieldList
   */
  protected void setHeaders(ArrayList<ArrayList<String>> fieldList) {
    fields = new HashMap<String, Integer>();
    for (ArrayList<String> entry : fieldList) {
      headers.add(entry.get(0));
      fields.put(entry.get(0), Integer.parseInt(entry.get(1)));
    }
  }

}// DBListener

