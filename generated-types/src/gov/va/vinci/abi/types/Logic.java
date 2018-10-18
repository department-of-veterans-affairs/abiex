

/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.abi.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Oct 18 08:42:11 MDT 2018
 * XML source: /var/folders/8t/nmg009gn1y12522l1gmzl14w0000gp/T/leoTypeDescription_23881bad-de27-4190-ae08-566db4f5acb97892693370655006136.xml
 * @generated */
public class Logic extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Logic.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Logic() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Logic(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Logic(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Logic(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ABI_Value

  /** getter for ABI_Value - gets 
   * @generated
   * @return value of the feature 
   */
  public String getABI_Value() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_ABI_Value == null)
      jcasType.jcas.throwFeatMissing("ABI_Value", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_ABI_Value);}
    
  /** setter for ABI_Value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setABI_Value(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_ABI_Value == null)
      jcasType.jcas.throwFeatMissing("ABI_Value", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_ABI_Value, v);}    
   
    
  //*--------------*
  //* Feature: Index_Type

  /** getter for Index_Type - gets 
   * @generated
   * @return value of the feature 
   */
  public String getIndex_Type() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Index_Type == null)
      jcasType.jcas.throwFeatMissing("Index_Type", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Index_Type);}
    
  /** setter for Index_Type - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setIndex_Type(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Index_Type == null)
      jcasType.jcas.throwFeatMissing("Index_Type", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Index_Type, v);}    
   
    
  //*--------------*
  //* Feature: Laterality_Value

  /** getter for Laterality_Value - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLaterality_Value() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Laterality_Value == null)
      jcasType.jcas.throwFeatMissing("Laterality_Value", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Laterality_Value);}
    
  /** setter for Laterality_Value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLaterality_Value(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Laterality_Value == null)
      jcasType.jcas.throwFeatMissing("Laterality_Value", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Laterality_Value, v);}    
   
    
  //*--------------*
  //* Feature: Anatomy_Value

  /** getter for Anatomy_Value - gets 
   * @generated
   * @return value of the feature 
   */
  public String getAnatomy_Value() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Anatomy_Value == null)
      jcasType.jcas.throwFeatMissing("Anatomy_Value", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Anatomy_Value);}
    
  /** setter for Anatomy_Value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnatomy_Value(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Anatomy_Value == null)
      jcasType.jcas.throwFeatMissing("Anatomy_Value", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Anatomy_Value, v);}    
   
    
  //*--------------*
  //* Feature: Normalized_Value

  /** getter for Normalized_Value - gets 
   * @generated
   * @return value of the feature 
   */
  public float getNormalized_Value() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Normalized_Value == null)
      jcasType.jcas.throwFeatMissing("Normalized_Value", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Logic_Type)jcasType).casFeatCode_Normalized_Value);}
    
  /** setter for Normalized_Value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNormalized_Value(float v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Normalized_Value == null)
      jcasType.jcas.throwFeatMissing("Normalized_Value", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Logic_Type)jcasType).casFeatCode_Normalized_Value, v);}    
   
    
  //*--------------*
  //* Feature: Document_Date

  /** getter for Document_Date - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDocument_Date() {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Document_Date == null)
      jcasType.jcas.throwFeatMissing("Document_Date", "gov.va.vinci.abi.types.Logic");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Document_Date);}
    
  /** setter for Document_Date - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDocument_Date(String v) {
    if (Logic_Type.featOkTst && ((Logic_Type)jcasType).casFeat_Document_Date == null)
      jcasType.jcas.throwFeatMissing("Document_Date", "gov.va.vinci.abi.types.Logic");
    jcasType.ll_cas.ll_setStringValue(addr, ((Logic_Type)jcasType).casFeatCode_Document_Date, v);}    
  }

    