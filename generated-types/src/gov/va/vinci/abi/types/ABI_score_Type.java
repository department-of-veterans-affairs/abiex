
/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.abi.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import gov.va.vinci.leo.regex.types.RegularExpressionType_Type;

/** 
 * Updated by JCasGen Thu Oct 18 08:42:11 MDT 2018
 * @generated */
public class ABI_score_Type extends RegularExpressionType_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ABI_score.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.abi.types.ABI_score");



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ABI_score_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

  }
}



    