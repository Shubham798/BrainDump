import React from 'react';
import { Container, Typography, Paper } from '@mui/material';
import ThoughtForm from './components/ThoughtForm';
import ThoughtList from './components/ThoughtList';

function App() {
  return (
    <Container maxWidth="sm" sx={{ marginTop: 5 }}>
      <Paper elevation={3} sx={{ padding: 3 }}>
        <Typography variant="h4" align="center" gutterBottom>
          🧠 Brain Dump
        </Typography>
        <ThoughtForm />
        <ThoughtList />
      </Paper>
    </Container>
  );
}

export default App;
