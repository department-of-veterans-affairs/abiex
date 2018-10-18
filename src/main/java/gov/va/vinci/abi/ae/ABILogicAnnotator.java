package gov.va.vinci.abi.ae;

/*
 * #%L
 * Angina project
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


import gov.va.vinci.abi.types.*;
import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.ae.LeoBaseAnnotator;
import gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.types.CSI;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 @author vhaslcalbap
 @author vhaslcpatteo */
public class ABILogicAnnotator extends LeoBaseAnnotator {

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
  }
/**
Logic Annotator Process
 Find all overlapping instance of ABI_Pre (Laterality found immediately prior to the ABI Pattern)
 Find all overlapping instance of ABI_Post (Laterality found immediately after ther ABI Pattern)
 Find all overlapping instance of ABI_Window_Pre (No laterality found in immediate context, search back for titles, headers, or earlier mentions)

 If Pre then Pre Laterality
 Else If Post then Post Laterality
 Else If Pre window then Pre window Laterality
 else no laterality[]

 */



  public void annotate(JCas aJCas) throws AnalysisEngineProcessException {

   FSIterator<Annotation> prepatternList = this.getAnnotationListForType(aJCas, ABIPattern.class.getCanonicalName());
    FSIterator<Annotation> postpatternList = this.getAnnotationListForType(aJCas, ABIPatternPost.class.getCanonicalName());
    FSIterator<Annotation> nolatpatternList = this.getAnnotationListForType(aJCas, ABIPatternNoLaterality.class.getCanonicalName());
    FSIterator<Annotation> LeftpatternList = this.getAnnotationListForType(aJCas, ABIPatternLeftTemplate.class.getCanonicalName());
    FSIterator<Annotation> CSIList = this.getAnnotationListForType(aJCas, CSI.class.getCanonicalName());


/**
 * Add ReferenceDateTime as feature for  Chex Validation
 **/
    String date_value = "Not_Found";
    if (CSIList.hasNext()) {
      CSI sec = (CSI) CSIList.next();
      StringArray csi_data = sec.getRowData();
      if(csi_data != null){
        if(csi_data.size() > 2){
          date_value = csi_data.get(2);
        }
      }

    }

    try {
        while (prepatternList.hasNext() || postpatternList.hasNext() || nolatpatternList.hasNext() || LeftpatternList.hasNext()) {
            AnnotationPatternType p;
            if (prepatternList.hasNext()) {
                p = (ABIPattern) prepatternList.next();
            } else if (postpatternList.hasNext()) {
                p = (ABIPatternPost) postpatternList.next();
            } else if (nolatpatternList.hasNext()) {
                p = (ABIPatternNoLaterality) nolatpatternList.next();
            } else {
                p = (ABIPatternLeftTemplate) LeftpatternList.next();
            }
            ArrayList<Annotation> IndexList = new ArrayList<Annotation>();
            ArrayList<Annotation> IndexCloseList = new ArrayList<Annotation>();
            IndexCloseList.addAll(AnnotationLibrarian.getPreviousAnnotationsOfType(p, abiconceptwindow.type, 1, false));
            IndexList.addAll(AnnotationLibrarian.getAllOverlappingAnnotationsOfType(p, AbiConcept.type, false));
            Logic outAnnotation = (Logic) this.addOutputAnnotation(Logic.class.getCanonicalName(),
                    aJCas, p.getBegin(), p.getEnd());
            String value = "";
            String laterality_value = "";
            String Anatomy_value = "";
            String index_type = "";
            //Target is Laterality
            //Anchor is Score
            /**
             * Check for index type in Pattern, else set to Non_Specific
             * ABI
             * TBI
             * AAI
             * Non_Specific
             **/
            //Indexlist in Pattern
            //IndexclosestList if index is before/near but not a part of pattern
            //Check if the type is in the pattern(unless the type is the nonspecific type)
            if (IndexList.size() > 0) {
                AbiConcept index = (AbiConcept) IndexList.get(0);
                //Check if ABI_Concept type is of a nonspecific type, if so, use the nearest specific type
                //index_type = index.getConcept();

                if (index.getConcept() != "Non_Specific") {
                    index_type = index.getConcept();
                }
                else if (index.getConcept() == "Non_Specific") {
                    if (IndexCloseList.size() > 0) {
                        abiconceptwindow indexwindow = (abiconceptwindow) IndexCloseList.get(0);
                        int conceptdiff = p.getBegin() - indexwindow.getEnd();
                        if (conceptdiff < 500) {
                            index_type = indexwindow.getConcept();
                        } else {
                            index_type = "Non_Specific";
                        }
                    }
                    else {
                        index_type = "Non_Specific";
                    }
                }

                //Set Lookbehind to 100 characters
            } else if (IndexCloseList.size() > 0) {
                abiconceptwindow index = (abiconceptwindow) IndexCloseList.get(0);
                int conceptdiff = p.getBegin() - index.getEnd() ;
                if (conceptdiff < 500) {
                    index_type = index.getConcept();
                } else{
                    index_type = "Non_Specific";
                }
            } else {
                index_type = "Non_Specific";
            }




          /**
           * Check for Target in Pattern, set target concept to laterality value
           * Left
           * Right
           * Bilateral
          * */
          if (p.getTarget() != null) {
            if (p.getTarget() instanceof Laterality) {
              Laterality pr = (Laterality) p.getTarget();
              if (pr.getConcept() != null) {
                laterality_value = pr.getConcept();
              }
            }
          }

          /**
           * If laterality is not specifically in the pattern, use the sectionizer to search for nearest laterality
           * Template Pattern used for specific frequently occuring semi structured patterns
           * e.g.
           * Right Left
           * Thigh .89  .78
           * Calf .89  .78
           * ABI: .53 .63
           *
           *
           * Output: Right .53, Left .63
           * */
          else {

              ArrayList<Annotation> sectionList = new ArrayList<Annotation>();
              sectionList.addAll(AnnotationLibrarian.getAllOverlappingAnnotationsOfType(p, Section.type, false));
              //ctrl SectionLIST empty -- see patternList for reference
            if(p.getTypeIndexID()==ABIPatternLeftTemplate.type){
              ABI_score c = (ABI_score) p.getAnchor();
              value = c.getCoveredText();
              laterality_value = "Left";
            }
            else if (sectionList.size() > 0) {
                Section sec = (Section) sectionList.get(0);
                laterality_value = sec.getSectionHeaderText();

              }
            }

          /**
           * Use the Anchor in Pattern, set concept of Anchor to ABI_value
           * */

          if (p.getAnchor() != null) {
            if (p.getAnchor() instanceof ABI_score) {
              ABI_score c = (ABI_score) p.getAnchor();
              if (c.getConcept() != null) {
                Iterator<Annotation> aList = (Iterator<Annotation>) AnnotationLibrarian.getAllCoveredAnnotationsOfType(p, ABI_anatomy.type, false).iterator();
                if (aList.hasNext()) {
                  ABI_anatomy a = (ABI_anatomy) aList.next();
                  //if anatomy is on the left of the score
                  if (c.getBegin() > a.getEnd()) {
                    //if there are no more annotations of type anatomy between the first anatomy and value
                    if (AnnotationLibrarian.getAllCoveredAnnotationsOfType(a.getEnd(), c.getBegin(), aJCas, ABI_anatomy.type, false).size() == 0) {
                      Anatomy_value = a.getConcept();
                      //Anatomy_value = a.getCoveredText();
                    }
                  }
                }
                value = c.getCoveredText();
                //c.getConcept();
              }
            }
          }
          outAnnotation.setAnatomy_Value(Anatomy_value);
          outAnnotation.setABI_Value(value);
          outAnnotation.setLaterality_Value(laterality_value);
          outAnnotation.setDocument_Date(date_value);
          outAnnotation.setIndex_Type(index_type);
          //outAnnotation.setDocument_Date();
        }
    } catch (Exception e) {
      e.printStackTrace();
      throw new AnalysisEngineProcessException(e);
    }

  }

  @Override
  public LeoTypeSystemDescription getLeoTypeSystemDescription() {
    return new LeoTypeSystemDescription();
  }


}
