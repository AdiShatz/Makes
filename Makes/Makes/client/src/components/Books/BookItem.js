import React, {useContext, useEffect, useState} from "react";
import AuthContext from "../../store/auth-context";
import './BookItem.css'

const BookItem = (props) => {
  
  const authCtx = useContext(AuthContext);

  const [name, setName] = useState();
  const [bookId, setBookId] = useState();
  const [isGalleryItem, setIsGalleryItem] = useState();
  const [coverPhoto, setCoverPhoto] = useState();
  const [isDeleted, setIsDeleted] = useState(false);

    const ClickedHandler = (e) => {
      
       if(authCtx.isLoggedIn){
        localStorage.setItem('bookName', name);

       if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
       }
        else{
       props.onGalleryBookItemClicked(bookId);
        }

    }else{
      props.onNotLoggedIn();
    }
  };

  const DeleteHandler = () => {
    props.onGalleryItemDeletion(bookId);
    setIsDeleted(true);
    
};

useEffect(
  () => {
      setName(props.name);
      setBookId(props.bookId);
      setIsGalleryItem(props.isGalleryItem);
      setCoverPhoto(props.coverPhoto);
  },[props]
)
      
    return(
      <div className= {isDeleted ? "hide_card" : "show_card"}>
    {((bookId && isGalleryItem) || (isGalleryItem==='false')) && <div className='book-item hvrbox' name={name} onClick={ClickedHandler} >
        {coverPhoto && <img
        src={require("../../images/" + coverPhoto).default}
        alt= "Photo Unavailable"
        className='book-item__img hvrbox-layer_bottom'
        />}
        <div class="hvrbox-layer_top">
		      {name && <div class="hvrbox-text">{name}</div>}
        </div>
    </div>}
    <div className="centered">{isGalleryItem && isGalleryItem==='true' && bookId && <button className="trash-button" onClick={DeleteHandler}>🗑️</button> } </div>
      
          
    </div>
  
  );
}

export default BookItem;
