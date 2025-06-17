import React, { useEffect, useState } from 'react';
import { getThoughtById } from '../services/thoughtService';

const ThoughtItem = ({ id }) => {
  const [thought, setThought] = useState(null);

  useEffect(() => {
    if (id) {
      getThoughtById(id).then(res => setThought(res.data));
    }
  }, [id]);

  if (!thought) return <div>Select a thought to view</div>;

  return (
    <div>
      <h2>Thought Details</h2>
      <p>{thought.content}</p>
    </div>
  );
};

export default ThoughtItem;
