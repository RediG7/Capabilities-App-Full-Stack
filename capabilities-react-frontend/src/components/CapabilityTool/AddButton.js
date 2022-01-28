import React, { Component } from "react";
import Modal from "react-modal";
import AddCapability from "./AddCapability";
import { closeModalClearState } from "../../actions/CapabilityActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";

const customStyles = {
  content: {
    height: "500px",
  },
};

export class AddButton extends Component {
  state = {
    modalIsOpen: false,
  };

  openModal = () => {
    this.setState({ modalIsOpen: true });
  };

  closeModal = () => {
    this.props.closeModalClearState();
    this.setState({ modalIsOpen: false });
  };

  render() {
    return (
      <div>
        <React.Fragment>
          <button
            type="button"
            className="btn btn-outline-primary mb-3 text-left"
            onClick={this.openModal}
          >
            <i style={{ marginRight: "6px" }} className="far fa-plus-square" />{" "}
            Add Capability
          </button>
          <Modal
            ariaHideApp={false}
            isOpen={this.state.modalIsOpen}
            style={customStyles}
          >
            <button
              type="button"
              className="btn btn-danger mb-2"
              onClick={this.closeModal}
            >
              <i
                style={{ marginRight: "6px" }}
                className="far fa-times-circle mr-1"
              />
              Close Modal
            </button>

            <AddCapability closeModal={this.closeModal} />
          </Modal>
        </React.Fragment>
      </div>
    );
  }
}

AddButton.propTypes = {
  closeModalClearState: PropTypes.func.isRequired,
};

export default connect(
  null,
  { closeModalClearState }
)(AddButton);
