
/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.leo.annotationpattern.types;

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
public class AnnotationPatternType_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = AnnotationPatternType.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
 
  /** @generated */
  final Feature casFeat_anchor;
  /** @generated */
  final int     casFeatCode_anchor;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnchor(int addr) {
        if (featOkTst && casFeat_anchor == null)
      jcas.throwFeatMissing("anchor", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    return ll_cas.ll_getRefValue(addr, casFeatCode_anchor);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnchor(int addr, int v) {
        if (featOkTst && casFeat_anchor == null)
      jcas.throwFeatMissing("anchor", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    ll_cas.ll_setRefValue(addr, casFeatCode_anchor, v);}
    
  
 
  /** @generated */
  final Feature casFeat_anchorPattern;
  /** @generated */
  final int     casFeatCode_anchorPattern;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAnchorPattern(int addr) {
        if (featOkTst && casFeat_anchorPattern == null)
      jcas.throwFeatMissing("anchorPattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_anchorPattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnchorPattern(int addr, String v) {
        if (featOkTst && casFeat_anchorPattern == null)
      jcas.throwFeatMissing("anchorPattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    ll_cas.ll_setStringValue(addr, casFeatCode_anchorPattern, v);}
    
  
 
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
      jcas.throwFeatMissing("pattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPattern(int addr, String v) {
        if (featOkTst && casFeat_pattern == null)
      jcas.throwFeatMissing("pattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    ll_cas.ll_setStringValue(addr, casFeatCode_pattern, v);}
    
  
 
  /** @generated */
  final Feature casFeat_target;
  /** @generated */
  final int     casFeatCode_target;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTarget(int addr) {
        if (featOkTst && casFeat_target == null)
      jcas.throwFeatMissing("target", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    return ll_cas.ll_getRefValue(addr, casFeatCode_target);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTarget(int addr, int v) {
        if (featOkTst && casFeat_target == null)
      jcas.throwFeatMissing("target", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    ll_cas.ll_setRefValue(addr, casFeatCode_target, v);}
    
  
 
  /** @generated */
  final Feature casFeat_targetPattern;
  /** @generated */
  final int     casFeatCode_targetPattern;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTargetPattern(int addr) {
        if (featOkTst && casFeat_targetPattern == null)
      jcas.throwFeatMissing("targetPattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    return ll_cas.ll_getStringValue(addr, casFeatCode_targetPattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTargetPattern(int addr, String v) {
        if (featOkTst && casFeat_targetPattern == null)
      jcas.throwFeatMissing("targetPattern", "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType");
    ll_cas.ll_setStringValue(addr, casFeatCode_targetPattern, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public AnnotationPatternType_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_anchor = jcas.getRequiredFeatureDE(casType, "anchor", "uima.tcas.Annotation", featOkTst);
    casFeatCode_anchor  = (null == casFeat_anchor) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_anchor).getCode();

 
    casFeat_anchorPattern = jcas.getRequiredFeatureDE(casType, "anchorPattern", "uima.cas.String", featOkTst);
    casFeatCode_anchorPattern  = (null == casFeat_anchorPattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_anchorPattern).getCode();

 
    casFeat_pattern = jcas.getRequiredFeatureDE(casType, "pattern", "uima.cas.String", featOkTst);
    casFeatCode_pattern  = (null == casFeat_pattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pattern).getCode();

 
    casFeat_target = jcas.getRequiredFeatureDE(casType, "target", "uima.tcas.Annotation", featOkTst);
    casFeatCode_target  = (null == casFeat_target) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_target).getCode();

 
    casFeat_targetPattern = jcas.getRequiredFeatureDE(casType, "targetPattern", "uima.cas.String", featOkTst);
    casFeatCode_targetPattern  = (null == casFeat_targetPattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_targetPattern).getCode();

  }
}



    