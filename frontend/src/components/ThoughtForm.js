import React, { useState } from 'react';
import { TextField, Button, Box } from '@mui/material';
import { createThought } from '../api';

function ThoughtForm() {
  const [content, setContent] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!content.trim()) return;
    await createThought({ content });
    setContent('');
    window.location.reload(); // For now, reload to update list
  };

  return (
    <Box component="form" onSubmit={handleSubmit} sx={{ display: 'flex', gap: 1, mb: 2 }}>
      <TextField
        label="New Thought"
        variant="outlined"
        fullWidth
        value={content}
        onChange={(e) => setContent(e.target.value)}
      />
      <Button type="submit" variant="contained">
        Add
      </Button>
    </Box>
  );
}

export default ThoughtForm;
