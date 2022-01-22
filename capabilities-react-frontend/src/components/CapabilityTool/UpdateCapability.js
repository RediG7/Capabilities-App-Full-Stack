import React, { Component } from "react";
import classnames from "classnames";

export class UpdateCapability extends Component {
  render() {
    const errors = {};
    return (
      <div className="card mb-3">
        <div className="card-header bg-danger text-light">
          Update Capability
        </div>
        <div className="card-body">
          <form>
            <div className="form-group">
              <label htmlFor="techStack">Technology Stack</label>
              <input
                type="text"
                name="techStack"
                value=""
                className={classnames("form-control form-control-lg", {
                  "is-invalid": errors.techStack,
                })}
              />
              {errors.techStack && (
                <div className="invalid-feedback">{errors.techStack}</div>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="numOfDevelopers">
                Total Developers in Capability
              </label>
              <input
                type="text"
                name="numOfDevelopers"
                value=""
                className="form-control form-control-lg"
              />
            </div>
            <div className="form-group">
              <label htmlFor="numOfAvailableDevelopers">
                Available developers for hire
              </label>
              <input
                type="text"
                name="numOfAvailableDevelopers"
                value=""
                className="form-control form-control-lg"
              />
            </div>
            <input
              type="submit"
              value="Update Capability"
              className="btn btn-danger btn-block"
              style={{ marginTop: "12px", width: "100%" }}
            />
          </form>
        </div>
      </div>
    );
  }
}

export default UpdateCapability;
