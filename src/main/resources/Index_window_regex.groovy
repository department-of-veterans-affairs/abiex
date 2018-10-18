import gov.va.vinci.leo.regex.types.RegularExpressionType
import gov.va.vinci.leo.window.types.Window

/* An arbitrary name for this annotator. Used in the pipeline for the name of this annotation. */
name = "MyRegexAnnotator"

configuration {
    /* All configuration for this annotator. */
    defaults {
        /* Global for all configrations below if a property specified here is not overridden in a section below. */
        //String[] inputTypes = [Window.class.getCanonicalName()]
        outputType = RegularExpressionType.class.canonicalName
        case_sensitive = false
        matchedPatternFeatureName = "pattern"
        concept_feature_name = "concept"
        groupFeatureName = "group"
    }

    /* An arbitrary name for this set of patterns/config. */

    "abi" {
        expressions = [
                '\bABI.?',
                'ABI',
                'abis?:',
                'abi\'s',
                'abix',
                'Ankle.?Brachial.?Index.?',
                'ankle.?brachial.?indices.?',
                'Ankle\\s*Brachial\\s*Index',
                'ankle\\s*brachial\\s*indices',
                'Brachial.?Index',
                'ANKLE',
                'ankle/brachial',
                'abi/rest',
                'ABI\\s*\\(numeric value\\)',
                'ABI\\s*value'
        ]
        concept_feature_value = "ABI"
        outputType = "gov.va.vinci.abi.types.abiconceptwindow"
    }
    "tbi" {
        expressions = [
                '\\d-\\d\\s*toes',
                'toe\\s*ind(ex|ices)',
                'toe\\s*pressure.?',
                'toe/brachial\\s*ind(ex|ices).?',
                'toe-brachial\\s*ind(ex|ices).?',
                'toe\\s*brachial\\s*ind(ex|ices).?',
                'TBI.?',
                'hallux/brachial',
                'toe\\s*press(ure)?',
                'toe\\s*press:',
                'toe\\s*press:\\.{1,8}'


        ]
        concept_feature_value = "TBI"
        outputType = "gov.va.vinci.abi.types.abiconceptwindow"
    }
    "dbi" {
        expressions = [

                'digit/brachial',
                'digit\\s*brachial\\s*ind(ex|ices)',
                'digit:',
                'digit\b',
                'DBI.?',
                'finger\\s*brachial\\s*index',
                'DIGIT BRACHIAL INDEX PERFORMED'


        ]
        concept_feature_value = "DBI"
        outputType = "gov.va.vinci.abi.types.abiconceptwindow"
    }



    "AAI" {
        expressions = [
                'AAI'
                ,'Ankle.?arm.?Index'
                ,'ankle/arm\\s*pres(sure)?\\s*index'
                ,'##new'
                ,'ankle.?arm'
                ,'ankle\\s*arm\\s*pressure'
                ,'ankle\\s*brachial\\s*pressure'
                ,'arm.?index'
                ,'arm.?indices'
                ,'ankle\\s*pressure\\s*index'
                ,'arm\\s*pressure\\s*index'
                ,'forearm\\s*brachial\\s*index'
        ]

        concept_feature_value = "AAI"
        outputType = "gov.va.vinci.abi.types.abiconceptwindow"
    }


}

