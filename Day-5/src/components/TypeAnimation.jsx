// TypingAnimation.jsx
import React, { useState, useEffect } from 'react';

const TypingAnimation = () => {
  const [text, setText] = useState('');
  const fullText = 'Get Your Education Today.';

  useEffect(() => {
    let index = 0;
    const intervalId = setInterval(() => {
      setText(fullText.slice(0, index));
      index++;
      if (index > fullText.length) {
        clearInterval(intervalId);
      }
    }, 100);

    return () => {
      clearInterval(intervalId);
    };
  }, []);

  return (
    <div className="typing-animation-container">
      <h1>{text}</h1>
    </div>
  );
};

export default TypingAnimation;
