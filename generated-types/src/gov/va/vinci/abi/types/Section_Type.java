
/* First created by JCasGen Thu Oct 18 08:42:11 MDT 2018 */
package gov.va.vinci.abi.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Section Type
 * Updated by JCasGen Thu Oct 18 08:42:11 MDT 2018
 * @generated */
public class Section_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Section.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.abi.types.Section");
 
  /** @generated */
  final Feature casFeat_SectionHeader;
  /** @generated */
  final int     casFeatCode_SectionHeader;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSectionHeader(int addr) {
        if (featOkTst && casFeat_SectionHeader == null)
      jcas.throwFeatMissing("SectionHeader", "gov.va.vinci.abi.types.Section");
    return ll_cas.ll_getRefValue(addr, casFeatCode_SectionHeader);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSectionHeader(int addr, int v) {
        if (featOkTst && casFeat_SectionHeader == null)
      jcas.throwFeatMissing("SectionHeader", "gov.va.vinci.abi.types.Section");
    ll_cas.ll_setRefValue(addr, casFeatCode_SectionHeader, v);}
    
  
 
  /** @generated */
  final Feature casFeat_SectionHeaderText;
  /** @generated */
  final int     casFeatCode_SectionHeaderText;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSectionHeaderText(int addr) {
        if (featOkTst && casFeat_SectionHeaderText == null)
      jcas.throwFeatMissing("SectionHeaderText", "gov.va.vinci.abi.types.Section");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SectionHeaderText);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSectionHeaderText(int addr, String v) {
        if (featOkTst && casFeat_SectionHeaderText == null)
      jcas.throwFeatMissing("SectionHeaderText", "gov.va.vinci.abi.types.Section");
    ll_cas.ll_setStringValue(addr, casFeatCode_SectionHeaderText, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Section_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SectionHeader = jcas.getRequiredFeatureDE(casType, "SectionHeader", "uima.tcas.Annotation", featOkTst);
    casFeatCode_SectionHeader  = (null == casFeat_SectionHeader) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SectionHeader).getCode();

 
    casFeat_SectionHeaderText = jcas.getRequiredFeatureDE(casType, "SectionHeaderText", "uima.cas.String", featOkTst);
    casFeatCode_SectionHeaderText  = (null == casFeat_SectionHeaderText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SectionHeaderText).getCode();

  }
}



    