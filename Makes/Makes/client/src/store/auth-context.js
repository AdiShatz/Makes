import React, {useState} from 'react';

const AuthContext = React.createContext({
    token:'',
    username: 'אורח',
    isLoggedIn: false,
    login: (token) => {},
    logout: () => {}
});

export const AuthContextProvider = (props) => {
    const [token, setToken] = useState(null);
    const [username, setUsername] = useState('אורח');

    const userIsLoggedIn = !!token; // convert string to bolean

    const loginHandler = (token, username) => {
        setToken(token);
        setUsername(username)
    };

    const logoutHandler = () => {
        setToken(null);
        setUsername('אורח')
    };

    const contextValue = {
        token: token,
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