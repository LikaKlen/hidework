import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080', // замените на адрес вашего бэкенда
});

export default api;
