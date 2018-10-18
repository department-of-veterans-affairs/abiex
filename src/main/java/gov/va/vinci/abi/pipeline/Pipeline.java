package gov.va.vinci.abi.pipeline;

/*
 * #%L
 * Leo Examples
 * %%
 * Copyright (C) 2010 - 2014 Department of Veterans Affairs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import gov.va.vinci.abi.AbiTypeSystem;
import gov.va.vinci.abi.ae.ABILogicAnnotator;
import gov.va.vinci.abi.ae.RegexBasedSectionizer;
import gov.va.vinci.leo.annotationpattern.ae.AnnotationPatternAnnotator;
import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.filter.ae.FilterAnnotator;
import gov.va.vinci.leo.merger.ae.MergeAnnotator;
import gov.va.vinci.leo.regex.ae.RegexAnnotator;
import gov.va.vinci.leo.window.ae.WindowAnnotator;
import gov.va.vinci.leo.window.types.Window;
import java.util.ArrayList;

public class Pipeline extends BasePipeline {
	/**
	 *
	 * @throws Exception
	 */
	public Pipeline() throws Exception {
		/** List for holding our annotators. This list, and the order of the list
		 * create the annotator pipeline.
		 */
		ArrayList<LeoAEDescriptor> annotators = new ArrayList<LeoAEDescriptor>();
		/**
		 * Run regex on the document for ABI terms
		 */
		annotators.add(new RegexAnnotator()
				.setGroovyConfigFile("src/main/resources/Index_Regex.groovy")
				.setName("Index Regex")
				.getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new RegexAnnotator()
				.setGroovyConfigFile("src/main/resources/Index_window_Regex.groovy")
				.setName("Index window Regex")
				.getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new RegexAnnotator()
				.setGroovyConfigFile("src/main/resources/Laterality_Regex.groovy")
				.setName("Laterality Regex")
				.getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.Laterality"})
				.getLeoAEDescriptor().setName("LateralityFilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		// Create a window after the ABI concept Word
		annotators.add(new WindowAnnotator()
				.setLtWindowSize(5)
				.setRtWindowSize(10)
				.setAnchorFeature("Anchor")
				.setOutputType(Window.class.getCanonicalName())
				.setInputTypes("gov.va.vinci.abi.types.AbiConcept")
				.setName("Window")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		/**
		 *Annotate concept words of interest that exist within the window
		 * Only those terms found in the window are annotated.  This is done to reduce the
		 * Size of terms processed by this annotator.
		 */
		//running the annotator on entire documents.
		annotators.add(new RegexAnnotator()
				.setResource("src/main/resources/Abi_Middle_Stuff.regex")
				.setOutputType("gov.va.vinci.abi.types.ABI_word")
				.setInputTypes(Window.class.getCanonicalName())
				.setName("RegexAbiWordAnnotator")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		/**
		 *Tested an Irrelevent index annotator
		 *Needs further refinement if used
		 *However, may restrict documents to only those that contain ABI terms, which would
		 *Likely get rid of a number of the irrelevent index types (Sleep assesment, etc.)
		 */
   /* annotators.add(new RegexAnnotator()
            .setResource("src/main/resources/Irrelevant_Index.regex")
            .setOutputType("gov.va.vinci.abi.types.Irrelevant_Index")
            .setInputTypes(Window.class.getCanonicalName())
            .setName("RegexIrrelevantAnnotator")
            .getLeoAEDescriptor()
            .setTypeSystemDescription(getLeoTypeSystemDescription()));
            */
		
		/**
		 * Anatomy Annotators
		 */
		
		annotators.add(new RegexAnnotator()
				.setResource("src/main/resources/Abi_anatomy.regex")
				.setInputTypes(Window.class.getCanonicalName())
				.setOutputType("gov.va.vinci.abi.types.ABI_anatomy")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		annotators.add(new RegexAnnotator()
				.setResource("src/main/resources/Abi_score.regex")
				.setConceptFeatureName("concept")
				.setConceptFeatureValue("Abi_Score")
				.setInputTypes(Window.class.getCanonicalName())
				.setOutputType("gov.va.vinci.abi.types.ABI_score")
				.setName("RegexAbiScoreAnnotator")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		/**
		 * Annotate inccorect terms and phrases
		 * 1st Pattern Exclusions (abi_exclude.regex)
		 * 2nd score exclusions  (Exclude_score.regex)
		 */
		annotators.add(new RegexAnnotator()
				.setResource("src/main/resources/Abi_exclude.regex")
				.setOutputType("gov.va.vinci.abi.types.Exclude")
				.setName("RegexScoreExcludeAnnotator")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		annotators.add(new RegexAnnotator()
				.setResource("src/main/resources/Exclude_Score.regex")
				.setOutputType("gov.va.vinci.abi.types.ExcludeScore")
				.setName("RegexScoreExcludeAnnotator")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/Exclude.pattern")
				.setOutputType("gov.va.vinci.abi.types.ExcludePattern")
				.setName("ExcludeAnnotator")
				.getLeoAEDescriptor()
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/Exclude_Index.pattern")
				.setOutputType("gov.va.vinci.abi.types.Exclude_Index")
				.setName("ExcludeIndexAnnotator")
				.getLeoAEDescriptor()
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		
		
		/**
		 * Remove extra annotations
		 * 1st Remove annotations of the same type that overlap
		 * 2nd remove annotations that overalap with Excluded concepts
		 */
		
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.AbiConcept",
						"gov.va.vinci.abi.types.ABI_score",
						"gov.va.vinci.abi.types.Exclude",
						"gov.va.vinci.abi.types.ABI_word",
						"gov.va.vinci.abi.types.Laterality",
						"gov.va.vinci.abi.types.ExcludePattern",
						"gov.va.vinci.abi.types.ABI_anatomy"})
				.getLeoAEDescriptor().setName("FilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		
		/* Filter annotator removes all ABI_scores if they are overlapping with ExcludeScore patterns*/
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.ExcludeScore"})
				.setTypesToDelete(new String[]{"gov.va.vinci.abi.types.ABI_score"})
				.setRemoveOverlapping(true)
				.getLeoAEDescriptor().setName("ScoreFilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.ExcludePattern"})
				.setTypesToDelete(new String[]{"gov.va.vinci.abi.types.AbiConcept",
						"gov.va.vinci.abi.types.ABI_score",
						"gov.va.vinci.abi.types.Exclude",
						"gov.va.vinci.abi.types.ABI_word",
						"gov.va.vinci.abi.types.Laterality",
						"gov.va.vinci.abi.types.ABI_anatomy",})
				.setRemoveOverlapping(true)
				.getLeoAEDescriptor().setName("FilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		
		annotators.add(new RegexBasedSectionizer()
				.setName("SectionAnnotator")
				.getLeoAEDescriptor().setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		/**
		 * Pattern Annotators
		 * ABI (ABI_PRE - When Laterality is found to the Left of the Score)
		 * ABI_Post (When Laterality is found to the Right of the Score)
		 * ABI_No_Laterality (When No Laterality is found in the pattern
		 * ABI_Template (Specific patterns that require the window rules found in the logic annotator)
		 */
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/ABI_Pattern.pattern")
				.setOutputType("gov.va.vinci.abi.types.ABIPattern")
				.getLeoAEDescriptor().setName("ABI_Pattern")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/ABI_Pattern_Post.pattern")
				.setOutputType("gov.va.vinci.abi.types.ABIPatternPost")
				.getLeoAEDescriptor().setName("ABI_Pattern_Post")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/ABI_Pattern_No_Laterality.pattern")
				.setOutputType("gov.va.vinci.abi.types.ABIPatternNoLaterality")
				.getLeoAEDescriptor().setName("ABI_Pattern_No_Laterality")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new AnnotationPatternAnnotator()
				.setResource("src/main/resources/Left_Template.pattern")
				.setOutputType("gov.va.vinci.abi.types.ABIPatternLeftTemplate")
				.getLeoAEDescriptor().setName("ABI_Pattern_Left_Template")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		/**
		 * Merge Duplicate patters of the same type.
		 */
		annotators.add(new MergeAnnotator()
				.setTypesToMerge(new String[]{"gov.va.vinci.abi.types.ABIPatternPost"})
				.setOutputType("gov.va.vinci.abi.types.ABIPatternPost")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new MergeAnnotator()
				.setTypesToMerge(new String[]{"gov.va.vinci.abi.types.ABIPattern"})
				.setOutputType("gov.va.vinci.abi.types.ABIPattern")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new MergeAnnotator()
				.setTypesToMerge(new String[]{"gov.va.vinci.abi.types.ABIPatternNoLaterality"})
				.setOutputType("gov.va.vinci.abi.types.ABIPatternNoLaterality")
				.getLeoAEDescriptor()
				.setTypeSystemDescription(getLeoTypeSystemDescription()));
		
		/**
		 * Apply Logic to get final Type
		 * Set Laterality:
		 *    1st Pre patterns
		 *    2nd Post Patterns
		 *    3rd Window Patterns
		 */
		
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.ABIPattern"})
				.setTypesToDelete(new String[]{"gov.va.vinci.abi.types.ABIPatternNoLaterality",
						"gov.va.vinci.abi.types.ABIPatternPost"})
				.setRemoveOverlapping(true)
				.getLeoAEDescriptor().setName("FilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new FilterAnnotator()
				.setTypesToKeep(new String[]{"gov.va.vinci.abi.types.ABIPatternPost"})
				.setTypesToDelete(new String[]{"gov.va.vinci.abi.types.ABIPatternNoLaterality"})
				.setRemoveOverlapping(true)
				.getLeoAEDescriptor().setName("FilterAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		annotators.add(new ABILogicAnnotator().getLeoAEDescriptor()
				.setName("LogicAnnotator")
				.addTypeSystemDescription(getLeoTypeSystemDescription()));
		
		pipeline = new LeoAEDescriptor(annotators);
		
	}
	
	protected LeoTypeSystemDescription defineTypeSystem() {
		return AbiTypeSystem.getAbiTypeSystemDescription();
	}
	
	
}
