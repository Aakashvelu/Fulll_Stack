import { Carousel } from 'rsuite';
import img1 from './images/learn1.avif'
import img2 from './images/learn2.avif'
import img3 from './images/learn3.avif'
import img4 from './images/learn4.avif'
import img5 from './images/learn5.webp'

const Carousal = () => (
    <div className='caro'>

  <Carousel autoplay className="custom-slider">
    <img src={img1}   />
    <img src={img2}  />
    <img src={img3}  />
    <img src={img4}  />
    <img src={img5}  />
  </Carousel>
    </div>
);


export default Carousal;