import React from "react";
import { useNavigate } from "react-router-dom";

export const AboutPage: React.FC = () => {
  const navigate = useNavigate();

  return (
    <>
      <h1>Страница информации</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius doloribus eaque excepturi facilis, ipsam nisi rem quas. Aspernatur, veniam excepturi?</p>
      <button className="btn" onClick={() => navigate("/")}>Обратно к списку дел</button>
    </>
  );
};