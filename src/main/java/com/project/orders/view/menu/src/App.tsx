import './App.css'
import { useState } from "react"
import { Card } from './components/card/card';
import { useMenuData } from './hooks/useMenuData';
import { CreateModal } from './components/create-modal/create-modal';

function App() {
  const { data } = useMenuData();
  const [ isModalOpen, setIsModalOpen ] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  return (

  <div className="container">
    <h1>Espetaria</h1>
      <div className="card-grid">
        {data?.map(menuData =>
          <Card 
            title={menuData.title} 
            description={menuData.description} 
            price={menuData.price} 
            imgUrl={menuData.imgUrl}
          />
        )}
      </div>
        {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
        <button className='btn-new' onClick={ handleOpenModal }>Novo</button>
  </div>

  )
}

export default App
