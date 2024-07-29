package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @PostConstruct
    public void init() {

        productRepository.save
                (new Product(1L,
                        "BY12345",
                        "Apple",
                        "Описание",
                        new BigDecimal(1.12),
                        1.1,
                        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABPCAMAAAAqV5CTAAADAFBMVEVHcEy8u7vX1dPJyMjW0c3W0M7S0tLb29za2djZ19SzsrKtra3MxsPDw8LRzcu9vLyenp6Xl5anp6ehoaGampqNjY2Pj4+KiYm2q6R4eHlnZ2eZmZmCgYGRkZCLi4uFhYV9fXunmZKOjo2cnJyVlJR/f3+EhINtbW1dWz90dHTMbFOdnZ2ZmZmioKCiVCfnsH7CUUDvy6DSgGboyJt8Zg3v0KjZpI3kpoXty6DQgWxeXlxaWU/ew1rowaFqXhfZv3mamZqYbj/SjHjdx2Pnwp7fuo/lvITPg3DIdl/y0aPry4fkv4fXnorRbFXUcVPrv5G3ZkiqVzDYml6HbDaRYijSvlN7aDLCYU9/ezOKZCTSjE/ntYSbXSuZlEmvXDespVi+sjf////KQjfRSDnKQzjQQjfJPTfLRzrWSjLNNzPROTLXPzDOPDbKTj3WVzbVazj1rZD1s5TCpR7INTTaUjPWezrSTDzYYje3EiXwoIHFLjL2vZTuy2TUKS7Lqybn0FPu0mrzo4fNJy30u4TNMC7wmnrdkDPZsCrtwmHxtnjzqYnysYfqnGOjYCPVUz33vJ32x57ahzbmx1Hyw3zcbTWuVC3KVkLNgzLanS/q0l2+IyvMHCjcwTXgxEXvk3TfqUDduT3UcTbkz0rEgyrsrWrdsTrne1zZMzPwv2vnoW/fckLXclC+VTeQYB7bgTDJYU25jxfVuDTskWzxy3DpkF3bXiriiU+jdhHASzfRsiz2xZXUMDCveRjMah7GSTvIjSe9mhrOYjPoy2DQminth27Uji3ZuyPzx4e7diXYhkHvpne5gR/kpUzWgWDeSjq3UjOwnxCMbAjNdS++eQ/u0XfYpjDklUncdzHaQTu8NjXOTC/BYi6ubiLprlrphlvvuGPhWETgnVbFby7z0IbBYxvywHPUHSzjakrcjGjYY0WTiweDgQTWrRKfmQOpigubaxjWsDngu0vgnjvZbCjDeynmcFXjYU3dZz/YdiDjlm63ZirGeEPZm2DXkBfOlUNHcEyJRszuAAABAHRSTlMALRAgDQkUAQIGNDocJBgpSVk/RVGXd4oTy+N1sGGnssMkbGuNu6Hd9tT9YIMx/v7+v69P/Z1I6X7I7fP+LP04Phd20mcktvKO8e2WldrC+0Lp34ihstrR+rLC11zrrKLsFf////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8ADlOBmgAAC2ZJREFUWMPs11lMU/keB3BiIEJC5plXX3lgvTqaaIyO6LjPOE4md+bmPvT0dD1doKW10FK6AN0oFCo7tKUbBRTZylbKJkLL4gTZlU1lS8wdVgVRc3+nc5P7ek+Zl5v4C6Uv0E++v9/v/+cQEvK1vtbX+v+p0MikyNCw8PCI0Kio0Ii//vPDI89cuXn13r17v/6akHDnzu3bdxIun0lKunDhQmToX0SEnbn5m+vTJ99E99vug93WVj6Txl8//PbPunrrTNjxiRNXrsZ+WvEVv34L1d2927rb2t0qbNG5RBrR4cbY2Ni1hIvHJE4mxt+1rUCI7u63b4cBOZjZPfh8MFOyE6t1HR666zYboqOvXT5WmNCzN2JjP/mKoVMvXrzYg9fn7OzBqc+f341qY10rvlROX197XMO1WyeO0arTd2NjXRtjR0evX7zwjAwPA7Jjsptz3r1biY1dMczszqeVlZXNNYzdCjpLKBiuw4266OijI49nZMTj8TwZmNra3m7MMbkO3UYhe175AK+y9mtXgl3cs3f9boejro7z+sg60tbmaWtr+1dKRsqWaWVjo26TzWcylQxlWYCZu3YmOCTxrstdW/ths65ubOPTF2vbH4AMf/nyZayubpPPlzNpynIliqBpPNyZOxcZzF5Fxq/MGI21UD5Y1A28a8Dt7292ybv4NKZcPg8vDNEL6AEl7lYwt8DZBYPR+AGiGIWbm5t1m7NQ4+vjfObamkRCo0nKGfN0FEMFVB4vDZS56ETixoVvp321Dvf6hw/GWT6fze+SrM06x5eZs07JWnk5k91VLkcRhEoWUCm8tDRYsrlz3xAPonO7dVlVTS3u98u1Qv7srNM5Oz4+zpdADkl5OY0mBwQVkEhFLAqvDJQHc5eJGt/8pnO3+GWiLH/TomNxcf/9+/fLy/vL68uAMBnl5Qw2Q05HEIqAxaJSKBBl7kHZL0SjJMa6Wvxcjcivq6pqamqqcjx1OPYdDse6c83phFYxaAwlRMEQFplMJuFM2YM4gmt88qZap9NyZRp/lqiqKavqaaDgzbHslDCZ5XI6nYHKMQFGJwFBovBgMA/mEogt2Il4hc6VnKxJ12pEWTKNJisLMKinT/fHJV00ehodVQroShRWi8pLg/2iwGDKbicRCnLhum3an85NTk9P1mg13GSZRiYTwZco6+kyQyLQ8ygsVI+kYSiJSoLl4kFR5uaiifUr8fqCDoD89M7kZK5Gw5VxuVyZTAaxmt4ruxA2iYKiAgEdwzAqCXaYh0/f620gtl9n83W2zvT0fIDycIbLTU6GKBrY6eU1OUPPoghQDEExjM6jFJEpaVQqmUL2NnxPCDmdb1NAjPx0bXp+ch4QXC7MBbatyjEukchRlIcIMAGCwX5RyFQ4KRQyRGlICCcyk9MKm6IzPR9H8vLy8/LwOCIZhKnaH2d2SVD9PIwEHAzFSFQyy8ujUKhUVgOh9YqIV9vUEKJTAd/y/4PI8C1rWh+nMbsY0CyBAEEwEkqnwzjwLxa5qOFcGCGkUK1QdHam40gnGNAwfLdErpZ1Ph/uYARTwuDhmCAoHQiYPYlMZjWcI/KEFBa/qlYrOoeGFIqhzk48B3RLBIelpaWWD49ENBqG3/IgwFAwKplKIpEpVG/DuSiCSQpXFYWAvBlSaDWaZK5WJILrZXERLssuUOgBBF8xBIXVgrFDw4gliYgfUhdCDRUW4ohfq9X6s5paFhcX3UZI4mQyGUpMr4epoIgAAYREYVFZRdGEZhJ+GpDVmprm1ebmVYXar/b7XbqWlsUWR62xlel0jsP1iLDZAhQ38CRFZBYZEGKXFyCrNc3Nk80q8VKhWq22uVw6UKZrhYBAEjYipwECSeCPCmwvnHtYLmLnJORsJ468eaNSifubawDR6Wy6lWmDsbUVR2hsFAbDRvRwWBA4iSzoF7WoiOCJv5IP3WpenVxqFovFSzabTWezud3ThhlA4JzQhDQGjTZP0+tRhIohZJg8GZ/JZYIXZGFNf81SpkrcLM5ULYwuTC8sTPumpx/vHhzs8p006JWQ3cdmI/OIEsNghVksb1ERwVs46fpQs6oGctQAIgZkZXR7NHtnxzDz+PEMLBhbKBRyhMIPerpSzqDzyNQiQLy3TxH6e3Ii/s1kzdJSpliVCaWCLKNm045pNNuAI0KIwRZyOByhXllOR9E0aJU3roh1h9gTMewwIDXi0v7JTHFmf79qesdst5tM2dk4YhQC0gcIR4DK5XSMwvJ62+Pi4r4n+CBxZWhStbQkLi3NzBQDVWDKqcCVHUAsRgt8fJ/QMsHh8HEEoXrr4+rr6+N+IPpsd2NSDPtbKs7MLC0tlRbY7eZnz3KmSvB+PU7lcCwTllSLhQPnRU5Hqe3t7YD8cokgEnH6TSau/GlIK02mimfvct7hiMFgACWVkwrFYdOVdJK3vv05FNFuwRLfmOxXqaBdQFRLpdtmHMkpKcnOzjZkp1qA8Pl8Fo4QHopY7fXPnz98/uMPhJGIq4D0S6XSUmk1VKW9siLQL1AGBw2pFjyHD0bDnp/HkYcPH/4ziMf6izdgqwAJGNWVzypwxG4PIMUWQHwGaFffRB8MBIyYIILg99dkf4G0AKpaWl1RUQH9ysnJscPsSwYGLZxiqFRLHyD1eI6YmPvhwSChV/vPS3FFWgCI2V5RkQNTgYaVDBZPTBRbi+Gt7/Xrl2DExMT8eCokqEr67jwQlQXV29sVzxpN5sbGDhwZhHYVW609EOXlS0CeP8zNjYn5R7D//l4EpRJqG4COra2txo6OnKmBgcEe6561p8dabAUEjJjcR49+Cg8WOQkKjphNU/D5OJIxBUhPz96e1QrQ8MuXHz9+xI37l0JCjqWYzXZzSUdGRgb+ysgAZG9vZHhkGAqIV7lg/P0YBj6Xn89XNm7ZpwYyUlJAgH/jU3p7rNaRkZHhV1AwjUcB42Sggs0SdfO8uXGrYwA+HBfgrbfnyZORVx4AcgMx/nb/UkSgwgNFEIOfht+JSPyusXErA48AYXp7n+DlefXKk/sHFBg/nYqCCg0Ng/qv9j9ROAA/HxYaFXXxZ5h4BkT4vTel98nvYIx4PP9urO521ISiKADXHxiLIggowfEHHUGJw51XkBjfoclkbpr2Gfpyvoa+Rpt2XqFr731gaEWdhV5I4vmyOLA5Ht/ezufd7uWLfTikabpY9MhqMqak2w4EAjT8a7FID4Nv32GcJH84x+MZ2e1fYt8fPT5tPdvpphakXl/Xm0wxdNXhDlSBBW868uPw6+nH6fRb8hP5RS32m3ESRPPZbLh6Jsh1jNSyzFav3xeInFqGW2htvd9bpIqYhMk4e32ltVV2e2STZ+N1EgThO4M+htGwTILQSDE1NRRhNtKDS8ZwHoXJepxleb5RyTd5nmcZjHWSBOF7mYHtOt2u0WhYFeZSAQKj17IahuN6gyWQeDKJwiBJ1si4DP1KEioSKUS6uA63UUytIka/ZTaMrmN7gykU349jgqIoDMOgkjAISSBCGQPPli5QzKtKpUjXcaGAWY4I8ofDmDNBInznnBkJwxUuFhtoUiDqDmi3ryDYESjM2B7qTCGBEow8iJIV5ZmEp630KC7XDeTTg9r3Fhh2BEIlslhbjhhEHvGh9QmgFkKUxq1NgdIEIw5BkBzXBUYae5ItDgqdtAuhIMTQ6WnpXNxf8rC3yUGflmlaXMkgjDnyhJTwLzrPAAkFQT3q72E1tTRymjok6gQLmBQzSrESg9YXAAJ2Qz31Wr2hGBlekEDBEgwaceQR+G/oJFcQQVcDrNN5uDnmOzy4NbEII4049khUKC/Nq9P6AEhQM/LOyBdIUYKxVnJKLCJnms0S+Hxv2lckZZVa1buIVr67Oh8l/sNKjj2FauVR5sOvxjtaydWk9jX/FwTVDmHAXU5iAAAAAElFTkSuQmCC".getBytes(),
                        Product.Category.FRUITS, Product.Brand.NESTLE,
                        new Date(2024, Calendar.JULY, 29)));
    }
}
