import React, {useContext} from "react";
import Card from '../UI/Card';
import AuthContext from "../../store/auth-context";
import './BookItem.css'

const BookItem = (props) => {
  
  const authCtx = useContext(AuthContext);

    const ClickedHandler = () => {
      
      if(authCtx.isLoggedIn){
        localStorage.setItem('chosenBookName', props.name);

       if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
       }
        else{
        props.onGalleryBookItemClicked(props.name);
        }

    }else{
      props.onNotLoggedIn();
    }
  };

      
    return(

    <Card className='book-item' name={props.name}>
        <img
        src={require("../../images/" + props.coverPhoto).default}
        alt= "Photo Unavailable"
        className='book-item__img'
        onClick={ClickedHandler}/>

        <label className='book-item__name'>{props.name}</label>
        {props.isGalleryItem==='true' && <button onClick={props.onGalleryItemDeletion}>מחק</button> }       
    </Card>
  
  );
}

export default BookItem;
