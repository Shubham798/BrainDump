import axios from 'axios';

const API_BASE = 'http://localhost:8080/api'; // or your backend's IP if running on Raspberry Pi

export const getAllThoughts = () => axios.get(`${API_BASE}/thoughts`);
export const createThought = (thought) => axios.post(`${API_BASE}/thoughts`, thought);
export const deleteThought = (id) => axios.delete(`${API_BASE}/thoughts/${id}`);
