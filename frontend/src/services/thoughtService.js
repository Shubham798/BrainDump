import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/thoughts';

export const getAllThoughts = () => axios.get(BASE_URL);
export const getThoughtById = (id) => axios.get(`${BASE_URL}/${id}`);
export const createThought = (thought) => axios.post(BASE_URL, thought);
export const deleteThought = (id) => axios.delete(`${BASE_URL}/${id}`);