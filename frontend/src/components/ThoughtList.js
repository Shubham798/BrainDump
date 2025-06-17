import React, { useEffect, useState } from 'react';
import { List, ListItem, ListItemText, IconButton, Divider, Typography, Box } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import { getAllThoughts, deleteThought } from '../api';

function ThoughtList() {
  const [thoughts, setThoughts] = useState([]);

  useEffect(() => {
    getAllThoughts().then(res => setThoughts(res.data));
  }, []);

  const handleDelete = async (id) => {
    await deleteThought(id);
    setThoughts(thoughts.filter(t => t.id !== id));
  };

const formatDate = (ts) => {
  if (!ts || typeof ts !== 'string') return 'Invalid Datee';

  const dotIndex = ts.indexOf('.');
  const safeTs = dotIndex !== -1 ? ts.slice(0, dotIndex + 4) : ts;
  
  const date = new Date(safeTs);
  return isNaN(date) ? 'Invalid Date' : date.toLocaleString();
};

  return (
    <List>
      {thoughts.map((thought, index) => (
        <React.Fragment key={thought.id}>
          <ListItem
            alignItems="flex-start"
            secondaryAction={
              <IconButton edge="end" onClick={() => handleDelete(thought.id)}>
                <DeleteIcon />
              </IconButton>
            }
          >
            <ListItemText
              primary={
                <Typography variant="body1" sx={{ fontWeight: 'bold' }}>
                  {thought.content}
                </Typography>
              }
              secondary={
                <Box sx={{ mt: 0.5 }}>
                  <Typography variant="body2" color="text.secondary">
                    Tag: {thought.tag || 'None'}
                  </Typography>
                  <Typography variant="caption" color="text.secondary">
                    Created: {formatDate(thought.createdTimestamp)}
                  </Typography>
                </Box>
              }
            />
          </ListItem>
          {index < thoughts.length - 1 && <Divider component="li" />}
        </React.Fragment>
      ))}
    </List>
  );
}

export default ThoughtList;
