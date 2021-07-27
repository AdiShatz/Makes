import React from 'react';

import './BackButton.css';

const BackButton = (props) => {

  const onClickHandler = () =>{
    props.onBackButtonClicked(props);
  }

  return <button onClick={onClickHandler}>חזור</button>
};

export default BackButton;
