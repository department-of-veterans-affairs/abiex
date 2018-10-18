package gov.va.vinci.abi.ae;

import gov.va.vinci.abi.types.*;
import gov.va.vinci.leo.AnnotationLibrarian;
import gov.va.vinci.leo.ae.LeoBaseAnnotator;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.leo.descriptors.TypeDescriptionBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This annotator finds relevant sections
 */
public class RegexBasedSectionizer extends LeoBaseAnnotator {

    int maxSectionSize = 1000;


    @Override
    public void annotate(JCas aJCas) throws AnalysisEngineProcessException {
    /* Processing steps:                                               */
      /* 1. Identify if Header annotation exists in the document        */
        String documentText = aJCas.getDocumentText();
        int prevSecEnd = 0;
        Laterality prevSecHeader = null;
        ArrayList<Annotation> anList = new ArrayList<Annotation>();
        try {
            anList.addAll(AnnotationLibrarian.getAllAnnotationsOfType(aJCas, Laterality.class.getCanonicalName(), false));
        } catch (CASException e) {
            e.printStackTrace();
        }
        if (anList.size() > 0) {
            for (Annotation ann : anList) {
                // Step 1. Go through all SectionHeaders
                Laterality currSecHeader = (Laterality) ann;
                // Trim the header so that it does not interfere with blank lines
                if (StringUtils.isNotBlank(currSecHeader.getCoveredText())) {
                    AnnotationLibrarian.trimAnnotation(currSecHeader, false);
                }
                // Step 2. Use prevSecEnd variable to keep track of the end of the section before the current header
                prevSecEnd = currSecHeader.getBegin() - 1;

                // check if there was already currSecHeader header
                // create currSecHeader new section
                // Use prevSecHeader annotation to keep track of the annotation for the  previous section
                if (prevSecHeader != null) {
                    // At this time there are two section headers in play - prevSecHeader and currSecHeader
                    // Check to make sure that the section is longer than 3 characters
                    if (prevSecEnd - prevSecHeader.getEnd() + 1 > 3) {
                        int newSectionStart = prevSecHeader.getEnd();// + 1;
                        int newSectionEnd = prevSecEnd; // This end is either the beginning of the new header or up to maxSectionSize
                        // Check if the section is longer than 100
                        if (newSectionEnd - newSectionStart >= maxSectionSize) {
                            newSectionEnd = newSectionStart + maxSectionSize;
                        }
                        // Create new section annotation
                        Section newSec = (Section) this.addOutputAnnotation("gov.va.vinci.abi.types.Section",
                                aJCas, newSectionStart, newSectionEnd);
                        newSec.setSectionHeader(prevSecHeader);
                        newSec.setSectionHeaderText(prevSecHeader.getConcept());
                        if (StringUtils.isNotBlank(newSec.getCoveredText())) {
                            AnnotationLibrarian.trimAnnotation(newSec);
                        }
                    }
                }

                // set the previous section header to the new section header
                prevSecHeader = currSecHeader; // if currSecHeader is the first section header, it simply skips to the next section header
            }
            // Step 3. When all headers are done, this is the last section,
            //  which is the case when prevSecHeader is not null and the end is the end of the document
            if (prevSecHeader != null) {

                if (prevSecHeader.getEnd() + 1 < documentText.length() - 1) {
                    int newSectionStart = prevSecHeader.getEnd();// + 1;
                    int newSectionEnd = documentText.length();
                    // Check if the section is longer than 100
                    if (newSectionEnd - newSectionStart >= maxSectionSize) {
                        newSectionEnd = newSectionStart + maxSectionSize;
                    }
                    Section newSec = (Section) this.addOutputAnnotation(
                            "gov.va.vinci.abi.types.Section", aJCas, newSectionStart, newSectionEnd);
                    newSec.setSectionHeader(prevSecHeader);
                    newSec.setSectionHeaderText(prevSecHeader.getConcept());
                    if (!newSec.getSectionHeaderText().equalsIgnoreCase("separator")) {
                        if (StringUtils.isNotBlank(newSec.getCoveredText())) {
                            try {
                                AnnotationLibrarian.trimAnnotation(newSec);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
         /**/
    }


    @Override
    public LeoTypeSystemDescription getLeoTypeSystemDescription() {
        LeoTypeSystemDescription types = new LeoTypeSystemDescription();

        try {

            types.addType(TypeDescriptionBuilder.create("gov.va.vinci.abi.types.Section",
                    "Section Type", "uima.tcas.Annotation")
                    .addFeature("SectionHeader", "Anchor annotation around which the section was created", "uima.tcas.Annotation")
                    .addFeature("SectionHeaderText", "text of the header", "uima.cas.String")
                    .getTypeDescription());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return types;
    }


}
