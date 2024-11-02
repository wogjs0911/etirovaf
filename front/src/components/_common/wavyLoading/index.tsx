import React from 'react';
// import style from "./styled.module.css";

type WavyLoadingProps = {
  loadMoreRef: React.MutableRefObject<null>;
};

const Index = ({ loadMoreRef }: WavyLoadingProps) => {
  return (
    <div ref={loadMoreRef} data-testid='wavy-loading'>
      <div />
      <div />
      <div />
    </div>
  );
};

export default Index;
