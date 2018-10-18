
/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.abi.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Oct 18 08:42:11 MDT 2018
 * @generated */
public class Logic_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Logic.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.abi.types.Logic");
 
  /** @generated */
  final Feature casFeat_ABI_Value;
  /** @generated */
  final int     casFeatCode_ABI_Value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getABI_Value(int addr) {
        if (featOkTst && casFeat_ABI_Value == null)
      jcas.throwFeatMissing("ABI_Value", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ABI_Value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setABI_Value(int addr, String v) {
        if (featOkTst && casFeat_ABI_Value == null)
      jcas.throwFeatMissing("ABI_Value", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_ABI_Value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Index_Type;
  /** @generated */
  final int     casFeatCode_Index_Type;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getIndex_Type(int addr) {
        if (featOkTst && casFeat_Index_Type == null)
      jcas.throwFeatMissing("Index_Type", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Index_Type);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIndex_Type(int addr, String v) {
        if (featOkTst && casFeat_Index_Type == null)
      jcas.throwFeatMissing("Index_Type", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_Index_Type, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Laterality_Value;
  /** @generated */
  final int     casFeatCode_Laterality_Value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLaterality_Value(int addr) {
        if (featOkTst && casFeat_Laterality_Value == null)
      jcas.throwFeatMissing("Laterality_Value", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Laterality_Value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLaterality_Value(int addr, String v) {
        if (featOkTst && casFeat_Laterality_Value == null)
      jcas.throwFeatMissing("Laterality_Value", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_Laterality_Value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Anatomy_Value;
  /** @generated */
  final int     casFeatCode_Anatomy_Value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAnatomy_Value(int addr) {
        if (featOkTst && casFeat_Anatomy_Value == null)
      jcas.throwFeatMissing("Anatomy_Value", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Anatomy_Value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnatomy_Value(int addr, String v) {
        if (featOkTst && casFeat_Anatomy_Value == null)
      jcas.throwFeatMissing("Anatomy_Value", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_Anatomy_Value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Normalized_Value;
  /** @generated */
  final int     casFeatCode_Normalized_Value;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getNormalized_Value(int addr) {
        if (featOkTst && casFeat_Normalized_Value == null)
      jcas.throwFeatMissing("Normalized_Value", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_Normalized_Value);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNormalized_Value(int addr, float v) {
        if (featOkTst && casFeat_Normalized_Value == null)
      jcas.throwFeatMissing("Normalized_Value", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setFloatValue(addr, casFeatCode_Normalized_Value, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Document_Date;
  /** @generated */
  final int     casFeatCode_Document_Date;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDocument_Date(int addr) {
        if (featOkTst && casFeat_Document_Date == null)
      jcas.throwFeatMissing("Document_Date", "gov.va.vinci.abi.types.Logic");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Document_Date);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDocument_Date(int addr, String v) {
        if (featOkTst && casFeat_Document_Date == null)
      jcas.throwFeatMissing("Document_Date", "gov.va.vinci.abi.types.Logic");
    ll_cas.ll_setStringValue(addr, casFeatCode_Document_Date, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Logic_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ABI_Value = jcas.getRequiredFeatureDE(casType, "ABI_Value", "uima.cas.String", featOkTst);
    casFeatCode_ABI_Value  = (null == casFeat_ABI_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ABI_Value).getCode();

 
    casFeat_Index_Type = jcas.getRequiredFeatureDE(casType, "Index_Type", "uima.cas.String", featOkTst);
    casFeatCode_Index_Type  = (null == casFeat_Index_Type) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Index_Type).getCode();

 
    casFeat_Laterality_Value = jcas.getRequiredFeatureDE(casType, "Laterality_Value", "uima.cas.String", featOkTst);
    casFeatCode_Laterality_Value  = (null == casFeat_Laterality_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Laterality_Value).getCode();

 
    casFeat_Anatomy_Value = jcas.getRequiredFeatureDE(casType, "Anatomy_Value", "uima.cas.String", featOkTst);
    casFeatCode_Anatomy_Value  = (null == casFeat_Anatomy_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Anatomy_Value).getCode();

 
    casFeat_Normalized_Value = jcas.getRequiredFeatureDE(casType, "Normalized_Value", "uima.cas.Float", featOkTst);
    casFeatCode_Normalized_Value  = (null == casFeat_Normalized_Value) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Normalized_Value).getCode();

 
    casFeat_Document_Date = jcas.getRequiredFeatureDE(casType, "Document_Date", "uima.cas.String", featOkTst);
    casFeatCode_Document_Date  = (null == casFeat_Document_Date) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Document_Date).getCode();

  }
}



    