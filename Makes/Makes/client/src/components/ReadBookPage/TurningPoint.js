import React, {useEffect, useState}from "react";
import Card from "../UI/Card";

import './TurningPoint.css';

const TurningPoint = (props) => {
    const [tpData, setTPData] = useState();

    useEffect(
        () => {
                setTPData(props.data);
        },[props]
    )

    const clickHandler = (event) =>{
        props.onTurningPointChosen(event.target.id);
    }
    return (
            <Card className="t-p-card">
                {tpData && <p>{tpData.question}</p>}
                {tpData && <button id='left' onClick={clickHandler}>{tpData.options[0]}</button>}
                {tpData && <button id='right' onClick={clickHandler}>{tpData.options[1]}</button>}
            </Card>
    );
}
export default TurningPoint;