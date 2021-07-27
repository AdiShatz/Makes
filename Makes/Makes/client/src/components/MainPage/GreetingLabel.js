import React from "react";
import './GreetingLabel.css'

const GreetingLabel = (props) => {
    return(
        <label className="greetingLabel"> שלום {props.userName} </label>
    );
}

export default GreetingLabel;
