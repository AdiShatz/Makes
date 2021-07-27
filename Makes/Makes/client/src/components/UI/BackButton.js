import React from 'react';

import './BackButton.css';

const BackButton = (props) => {

  const onClickHandler = (event) =>{
    props.onBackButtonClicked();
  }

  return <button onClick={onClickHandler}>חזור</button>
};

export default BackButton;
