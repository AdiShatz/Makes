import React, {useState} from 'react';

const AuthContext = React.createContext({
    id:'',
    username: 'אורח',
    isLoggedIn: false,
    login: (id) => {},
    logout: () => {}
});

export const AuthContextProvider = (props) => {
    const [id, setid] = useState(null);
    const [username, setUsername] = useState('אורח');

    const userIsLoggedIn = !!id; // convert string to bolean

    const loginHandler = (id, username) => {
        setid(id);
        setUsername(username)
    };

    const logoutHandler = () => {
        setid(null);
        setUsername('אורח')
    };

    const contextValue = {
        id: id,
        username: username,
        isLoggedIn: userIsLoggedIn,
        login: loginHandler,
        logout: logoutHandler
    };

    return <AuthContext.Provider value={contextValue}>
        {props.children}
    </AuthContext.Provider>;
}

export default AuthContext;