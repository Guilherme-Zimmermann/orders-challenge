import "./card.css"

interface CardProps {
    title: string,
    description: string,
    price: number,
    imgUrl: string
}

export function Card({ title, description, price, imgUrl } : CardProps){
    return (
        <div className="card">
            <img src={imgUrl}/>
            <h2>{title}</h2>
            <p>{description}</p>
            <p><b>Preço: </b>{price}</p>
        </div>
    )
}