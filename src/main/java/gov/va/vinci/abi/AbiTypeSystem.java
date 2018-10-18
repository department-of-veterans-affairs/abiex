package gov.va.vinci.abi;

import gov.va.vinci.leo.annotationpattern.ae.AnnotationPatternAnnotator;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.descriptors.TypeDescriptionBuilder;
import gov.va.vinci.leo.regex.ae.RegexAnnotator;
import gov.va.vinci.leo.types.TypeLibrarian;
import gov.va.vinci.leo.window.ae.WindowAnnotator;
import org.apache.uima.resource.metadata.TypeDescription;
import org.apache.uima.resource.metadata.impl.TypeDescription_impl;

import java.io.File;

public class AbiTypeSystem {
	public static String TYPE_REGEX = "gov.va.vinci.leo.regex.types.RegularExpressionType";
	public static String TYPE_PATTERN = "gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType";
	public static String ANCHORED_SENTENCE_TYPE = "gov.va.vinci.leo.sentence.types.AnchoredSentence";
	public static String SENTENCE_TYPE = "gov.va.vinci.leo.sentence.types.Sentence";
	public static String TOKEN_TYPE = "gov.va.vinci.leo.whitespace.types.Token";
	public static String WORD_TOKEN_TYPE = "gov.va.vinci.leo.whitespace.types.WordToken";
	public static String WINDOW_TYOE = "gov.va.vinci.leo.window.types.Window";
	
	public static void main(String[] args) {
		try {
			LeoTypeSystemDescription types = new LeoTypeSystemDescription();
			types.addTypeSystemDescription(getAbiTypeSystemDescription());
			
			File srcDir = new File("generated-types/src");
			srcDir.mkdirs();
			
			File classesDir = new File("generated-types/classes");
			classesDir.mkdirs();
			
			types.jCasGen(srcDir.getCanonicalPath(), classesDir.getCanonicalPath());
			
			File resDir = new File("generated-types/resources/types");
			resDir.mkdirs();
			
			types.toXML(resDir.getCanonicalPath() + "/AbiTypeSystem.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static LeoTypeSystemDescription getAbiTypeSystemDescription() {
		LeoTypeSystemDescription description = new LeoTypeSystemDescription();
		try {
			description = new WindowAnnotator().getLeoTypeSystemDescription();
			description.addType(TypeLibrarian.getCSITypeSystemDescription());
			description.addTypeSystemDescription(new RegexAnnotator().getLeoTypeSystemDescription());
			description.addTypeSystemDescription(new AnnotationPatternAnnotator().getLeoTypeSystemDescription());
			
			description.addType("gov.va.vinci.abi.types.ABI_score", "", TYPE_REGEX);
			
			description.addType("gov.va.vinci.abi.types.Exclude", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.ExcludeScore", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.ABI_word", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.Laterality", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.AbiConcept", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.abiconceptwindow", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.ABI_anatomy", "", TYPE_REGEX);
			description.addType("gov.va.vinci.abi.types.Irrelevant_Index", "", TYPE_REGEX);
			
			
			description.addType(TypeDescriptionBuilder.create("gov.va.vinci.abi.types.Section",
					"Section Type", "uima.tcas.Annotation")
					.addFeature("SectionHeader", "Anchor annotation around which the section was created", "uima.tcas.Annotation")
					.addFeature("SectionHeaderText", "text of the header", "uima.cas.String")
					.getTypeDescription());
			
			
			description.addType("gov.va.vinci.abi.types.ExcludePattern", "", TYPE_PATTERN);
			description.addType("gov.va.vinci.abi.types.ABIPattern", "", TYPE_PATTERN);
			description.addType("gov.va.vinci.abi.types.ABIPatternPost", "", TYPE_PATTERN);
			description.addType("gov.va.vinci.abi.types.ABIPatternNoLaterality", "", TYPE_PATTERN);
			description.addType("gov.va.vinci.abi.types.ABIPatternLeftTemplate", "", TYPE_PATTERN);
			description.addType("gov.va.vinci.abi.types.Exclude_Index", "", TYPE_PATTERN);
			
			TypeDescription finalType = new TypeDescription_impl("gov.va.vinci.abi.types.Logic", "", "uima.tcas.Annotation");
			finalType.addFeature("ABI_Value", "", "uima.cas.String");
			finalType.addFeature("Index_Type", "", "uima.cas.String");
			finalType.addFeature("Laterality_Value", "", "uima.cas.String");
			finalType.addFeature("Anatomy_Value", "", "uima.cas.String");
			finalType.addFeature("Normalized_Value", "", "uima.cas.Float");
			finalType.addFeature("Document_Date", "", "uima.cas.String");
			description.addType(finalType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return description;
	}
}
