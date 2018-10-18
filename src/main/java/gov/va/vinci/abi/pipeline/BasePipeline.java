package gov.va.vinci.abi.pipeline;

import gov.va.vinci.leo.descriptors.LeoAEDescriptor;
import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;

public abstract class BasePipeline {
  LeoAEDescriptor pipeline = null;
  LeoTypeSystemDescription description = null;


  public LeoTypeSystemDescription getLeoTypeSystemDescription()  {
    if (description == null) {
      return defineTypeSystem();
    }else
      return description;
  }

  public LeoAEDescriptor getPipeline() {
    return pipeline;
  }

  protected abstract LeoTypeSystemDescription defineTypeSystem ();
}
