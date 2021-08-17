import React, {useEffect, useState}from "react";
import Button from "../UI/Button";
import Card from "../UI/Card";

import './TurningPoint.css';

const TurningPoint = (props) => {
    const [tpData, setTPData] = useState();

    useEffect(
        () => {
            if(props.data){
                setTPData(props.data);
                }
        },[props]
    )

    const clickHandler = (event) =>{
        props.onTurningPointChosen(event.target.id);
    }
    return (
            <Card>
                {tpData && <p>{tpData.text}</p>}
                {tpData &&<button id='left' onClick={clickHandler}>{tpData.leftOption}</button>}
                {tpData &&<button id='right' onClick={clickHandler}>{tpData.rightOption}</button>}
            </Card>
    );
}
export default TurningPoint;