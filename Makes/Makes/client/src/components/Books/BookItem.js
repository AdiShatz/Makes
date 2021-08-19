import React, {useContext, useEffect, useState} from "react";
import Card from '../UI/Card';
import AuthContext from "../../store/auth-context";
import './BookItem.css'

const BookItem = (props) => {
  
  const authCtx = useContext(AuthContext);

  const [name, setName] = useState();
  const [isGalleryItem, setIsGalleryItem] = useState();
  const [coverPhoto, setCoverPhoto] = useState();

  useEffect(
      () => {
          setName(props.name);
          setIsGalleryItem(props.isGalleryItem);
          setCoverPhoto(props.coverPhoto);
      },[props]
  )

    const ClickedHandler = () => {
      
       if(authCtx.isLoggedIn){
        localStorage.setItem('bookName', name);

       if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
       }
        else{
        props.onGalleryBookItemClicked(name);
        }

    }else{
      props.onNotLoggedIn();
    }
  };

      
    return(

    <div className='book-item hvrbox' name={name} onClick={ClickedHandler} >
        {coverPhoto && <img
        src={require("../../images/" + coverPhoto).default}
        alt= "Photo Unavailable"
        className='book-item__img hvrbox-layer_bottom'
        />}
        <div class="hvrbox-layer_top">
		      {name && <div class="hvrbox-text">{name}</div>}
        </div>
        {isGalleryItem && isGalleryItem==='true' && <button onClick={props.onGalleryItemDeletion}>מחק</button> }       
    </div>
  
  );
}

export default BookItem;
