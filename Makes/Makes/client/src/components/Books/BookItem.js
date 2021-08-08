import React, {useContext} from "react";
import Card from '../UI/Card';
import AuthContext from "../../store/auth-context";
import './BookItem.css'

const BookItem = (props) => {
  
  const authCtx = useContext(AuthContext);

    const ClickedHandler = () => {
      
      // if(authCtx.isLoggedIn){
        localStorage.setItem('chosenBookName', props.name);

       if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
       }
        else{
        props.onGalleryBookItemClicked(props.name);
        }

    // }else{
    //   props.onNotLoggedIn();
    // }
  };

      
    return(

    <div className='book-item hvrbox' name={props.name} onClick={ClickedHandler} >
        <img
        src={require("../../images/" + props.coverPhoto).default}
        alt= "Photo Unavailable"
        className='book-item__img hvrbox-layer_bottom'
        />
        <div class="hvrbox-layer_top">
		      <div class="hvrbox-text">{props.name}</div>
        </div>
        {props.isGalleryItem==='true' && <button onClick={props.onGalleryItemDeletion}>מחק</button> }       
    </div>
  
  );
}

export default BookItem;
