
/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.leo.regex.types;

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
public class RegularExpressionType_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = RegularExpressionType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.leo.regex.types.RegularExpressionType");
 
  /** @generated */
  final Feature casFeat_pattern;
  /** @generated */
  final int     casFeatCode_pattern;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPattern(int addr) {
        if (featOkTst && casFeat_pattern == null)
      jcas.throwFeatMissing("pattern", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPattern(int addr, String v) {
        if (featOkTst && casFeat_pattern == null)
      jcas.throwFeatMissing("pattern", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    ll_cas.ll_setStringValue(addr, casFeatCode_pattern, v);}
    
  
 
  /** @generated */
  final Feature casFeat_concept;
  /** @generated */
  final int     casFeatCode_concept;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getConcept(int addr) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_concept);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConcept(int addr, String v) {
        if (featOkTst && casFeat_concept == null)
      jcas.throwFeatMissing("concept", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    ll_cas.ll_setStringValue(addr, casFeatCode_concept, v);}
    
  
 
  /** @generated */
  final Feature casFeat_group;
  /** @generated */
  final int     casFeatCode_group;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getGroup(int addr) {
        if (featOkTst && casFeat_group == null)
      jcas.throwFeatMissing("group", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    return ll_cas.ll_getRefValue(addr, casFeatCode_group);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGroup(int addr, int v) {
        if (featOkTst && casFeat_group == null)
      jcas.throwFeatMissing("group", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    ll_cas.ll_setRefValue(addr, casFeatCode_group, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public String getGroup(int addr, int i) {
        if (featOkTst && casFeat_group == null)
      jcas.throwFeatMissing("group", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_group), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_group), i);
	return ll_cas.ll_getStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_group), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setGroup(int addr, int i, String v) {
        if (featOkTst && casFeat_group == null)
      jcas.throwFeatMissing("group", "gov.va.vinci.leo.regex.types.RegularExpressionType");
    if (lowLevelTypeChecks)
      ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_group), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_group), i);
    ll_cas.ll_setStringArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_group), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public RegularExpressionType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_pattern = jcas.getRequiredFeatureDE(casType, "pattern", "uima.cas.String", featOkTst);
    casFeatCode_pattern  = (null == casFeat_pattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pattern).getCode();

 
    casFeat_concept = jcas.getRequiredFeatureDE(casType, "concept", "uima.cas.String", featOkTst);
    casFeatCode_concept  = (null == casFeat_concept) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_concept).getCode();

 
    casFeat_group = jcas.getRequiredFeatureDE(casType, "group", "uima.cas.StringArray", featOkTst);
    casFeatCode_group  = (null == casFeat_group) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_group).getCode();

  }
}



    