import React, {useContext, useEffect, useState} from "react";
import AuthContext from "../../store/auth-context";
import './BookItem.css'

const BookItem = (props) => {
  
  const authCtx = useContext(AuthContext);

  const [name, setName] = useState();
  const [bookId, setBookId] = useState();
  const [isGalleryItem, setIsGalleryItem] = useState();
  const [coverPhoto, setCoverPhoto] = useState();

    const ClickedHandler = (e) => {
      
       if(authCtx.isLoggedIn){
        localStorage.setItem('bookName', name);

       if(props.isGalleryItem === 'false'){
        props.onBookItemClicked();
       }
        else{
        // console.log(e);
       props.onGalleryBookItemClicked(bookId);
        }

    }else{
      props.onNotLoggedIn();
    }
  };

  const DeleteHandler = () => {
    props.onGalleryItemDeletion(bookId);
};

useEffect(
  () => {
      setName(props.name);
      setBookId(props.bookId);
      setIsGalleryItem(props.isGalleryItem);
      setCoverPhoto(props.coverPhoto);
  },[props, ClickedHandler, DeleteHandler]
)
      
    return(
      <div>
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
    {isGalleryItem && isGalleryItem==='true' && bookId && <button onClick={DeleteHandler}>מחק</button> }       
    </div>
  
  );
}

export default BookItem;
