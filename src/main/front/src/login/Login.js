import React, { useState, useEffect } from 'react';

const Login = () => {
    const [message, setMessage] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/users/test');
                const data = await response.text();  // Utilisez response.text() pour récupérer une chaîne de caractères
                setMessage(data);
            } catch (error) {
                console.error('Error fetching data:', error.message);
                setMessage('Error calling backend');
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            <h2>Login</h2>
            <p>{message}</p>
            {/* ... reste de votre composant de connexion */}
        </div>
    );
};

export default Login;
