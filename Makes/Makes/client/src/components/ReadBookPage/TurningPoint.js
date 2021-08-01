import React from "react";
import Button from "../UI/Button";
import Card from "../UI/Card";

import './TurningPoint.css';

const TurningPoint = (props) => {

    const clickHandler = (event) =>{
        props.onTurningPointChosen(event.target.id);
    }
    return (
            <Card>
                <p>{props.data.text}</p>
                <button id='left' onClick={clickHandler}>{props.data.leftOption}</button>
                <button id='right' onClick={clickHandler}>{props.data.rightOption}</button>
            </Card>
    );
}
export default TurningPoint;