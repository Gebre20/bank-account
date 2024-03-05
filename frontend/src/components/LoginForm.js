import React, { useState } from 'react';
//import { useNavigation } from "react-router-dom";
import axios from 'axios';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  //const navigate = useNavigation();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Send login request to backend
      const data = { username, password };
      await axios.post('http://localhost:8080/login', data);
      // Handle successful login
      //console.log('Login successful:', response.data);
      
      //setError('');
      //navigate.push('/CustomerList')
    } catch (error) {
      // Handle login error
      //console.error('Login error:', error.response.data.message);
      //setError(error.response.data.message);
      //setError('');
      console.log(error)
    }
  };

  return (
    <form method='post' onSubmit={handleSubmit}>
      <h2>Login</h2>
      {error && <div style={{ color: 'red' }}>{error}</div>}
      <div>
        <label>Username:</label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;


