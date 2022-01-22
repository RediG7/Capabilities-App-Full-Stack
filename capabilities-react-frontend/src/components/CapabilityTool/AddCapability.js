import React, { Component } from "react";
import classnames from "classnames";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { addCapability } from "../../actions/CapabilityActions";

export class AddCapability extends Component {
  state = {
    techStack: "",
    numOfDevelopers: "",
    numOfAvailableDevelopers: "",
    errors: {},
  };

  // arrow functions autobinds, no need for constructor
  onChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  // arrow function -> autobind

  onSubmit = (e) => {
    e.preventDefault();
    const { techStack, numOfDevelopers, numOfAvailableDevelopers } = this.state;

    const newCapability = {
      techStack,
      numOfDevelopers,
      numOfAvailableDevelopers,
    };

    this.props.addCapability(newCapability, this.props.closeModal);
  };

  render() {
    const errors = {};
    return (
      <div className="card mb-3">
        <div className="card-header bg-primary text-light">Add Capability</div>
        <div className="card-body">
          <form onSubmit={this.onSubmit}>
            <div className="form-group">
              <label htmlFor="techStack">Technology Stack</label>
              <input
                type="text"
                name="techStack"
                value={this.state.techStack}
                className={classnames("form-control form-control-lg", {
                  "is-invalid": errors.techStack,
                })}
                onChange={this.onChange}
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
                type="number"
                name="numOfDevelopers"
                value={this.state.numOfDevelopers}
                className="form-control form-control-lg"
                onChange={this.onChange}
              />
            </div>
            <div className="form-group">
              <label htmlFor="name">Available developers for hire</label>
              <input
                type="number"
                name="numOfAvailableDevelopers"
                value={this.state.numOfAvailableDevelopers}
                className="form-control form-control-lg"
                onChange={this.onChange}
              />
            </div>
            <input
              style={{ marginTop: "12px", width: "100%" }}
              type="submit"
              value="Add Capability"
              className="btn btn-primary btn-block"
              onChange={this.onChange}
            />
          </form>
        </div>
      </div>
    );
  }
}

AddCapability.propTypes = {
  addCapability: PropTypes.func.isRequired,
};

export default connect(
  null,
  { addCapability }
)(AddCapability);
