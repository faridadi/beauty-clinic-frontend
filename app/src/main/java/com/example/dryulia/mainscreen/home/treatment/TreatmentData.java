package com.example.dryulia.mainscreen.home.treatment;

import com.example.dryulia.mainscreen.home.produk.ProdukModel;

import java.util.ArrayList;

public class TreatmentData {
    public static String[][] data = new String[][]{
            {"Peeling", "Peeling adalah treatment yang sangat baik untuk kesehatan kulit. Dengan melakukan peeling maka kulit akan menjadi cerah seketika", "data:image/jpeg;base64,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", "100000"},
            {"Peeling", "Peeling adalah treatment yang sangat baik untuk kesehatan kulit Dengan melakukan peeling maka kulit akan menjadi cerah seketika", "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEBIQEBIQFRAQDw8QEBAPDw8PEA8QFRUWFhUVFRUYHSggGBolGxUVITEhJSkrLi4uFx8zODUsNygtLisBCgoKDg0OGhAQGi0dHR0tLS0tLS0tLSstLS0tLS0tLS0tKy0tLS0tLS0tLS0tLS0tLS0tLS0tLSstLS0tLS0tLf/AABEIAOEA4QMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAADAAIEBQYBBwj/xAA6EAACAQIEBAMFBwMEAwEAAAAAAQIDEQQFEiEGMUFRE2GBIjJxkcEUQlKhsdHhI2LwBzNy8TVDghX/xAAZAQADAQEBAAAAAAAAAAAAAAABAgMABAX/xAAhEQACAgMAAgMBAQAAAAAAAAAAAQIRAxIhMUEEIlETMv/aAAwDAQACEQMRAD8AxlDByavtySu3ZJdVH8vkSoZPKbu367r5HpGHyKP4Vyty5k6lk0f4srHDselSR5esn0rlH42m3+xXY3BTS2V/gj2tZXHsvkCrZRB84xfoh02K6Pn+pCae68uo+GJmk1aX5rY9lxnCNCV7RcW+sW/0exmsw4Fe7jO/pYqpk9TF0M10qzSavybFDiCrBvwpShGXOKk9PyJ2YcKVYX528o3Rn8Tl84uz2fZ3Q6nYG2i9pcVV0klVk/Jmi4f469tRrLblrX1PNXBrn+oSlVkv8sUTF/oz6HwfEtKcU43a722LjC5nGXJnjnDPEDhTjCdnBbedi3q5vG7lQvst7ysmPZZU0esKou51MwHDXEMpx9rVqi7PsazC4+Muu4LDqWY2SBwqXCJmBQyUCBjcujUTTSLJoWkKdAcUzzjOOF5QvKl8jOyqOL0yTTXRns1Simt0ZnPuGoVU2laXRo7cXymuSOHN8RPsTz11i44XwjrVlf3adpS+iKbNMtq0JWknbpI2H+n0V4M5dZTt8kP8jPWNteyPx8N5En6NfRgTYMjUwrkeMj1pKx85karVscq1CpzDFWXMWUqGhCwOcY20XuecZvOdarGN9tRo81xLmmkU+TUfExUKa33vJ+SJX2zqUai0Wv8A+I+7Ebj7NERb+kjl1j+E2FBBfDDqI7SQ1JtkbwxrpkvSccApAsg1KQCdEsnAFKmGqDZS4jAp9ChzLh2E73ir97K5spUwFSkbZhpHi/EHC86d5RTa7cmv3MfWptOz2fZ3Po6vhFJWaTMbxHwRTrJygtM+nZ/sPGYkoHkdPFSj7rJ+EzCfup89m+o3O8gq4eWmpGSXRveL+D5MrKc9PK5aMhOo3mTZh4UWlUSvva/X4GiyvPpfei+fv22PNMDiEucdT57s1+QVp1NtKUG7bsay8JWerZTi/EgpJ3Xcs4SMhlFZ0pKEV7D2tfkaWjU/gYZonHUyOqoZMIo8bKIrnTAKzMsrhVi1JLcp8oyv7M5wXuylqXlc1bRBxsPa9BcjetGUVtZ2nKyGzrEOdVrZg51Dl2LKJ3F4qyZm8ZitT57EjMcQ77FRisLUnG1Nbv3t0tviLGLnKh3JY42yozjMkrwg9/vS+iLf/TfCXlUrPp7MfqVEuEMRJ7zpxXrJm44Zyz7NQVPVqe7crWu35G1ldsZ5YNVF2Xt2IF4ghyJfJDrCOgRysbYVjojGGtDHEKxtghsBKAGdMluIxxFoZMgzgQ8XUjCLlJpJFrNGD4wzZRvHov1A+DrpAzrPVUvTjQhOL5qqrprvYxuI4Lq1bzo03G7vZNqHwV22anhPBOvU1yT0ReqWp82/dX1+HxN5OmoqyW3RIKlQskmfOmMw1XDTcKkXGS/ErX+BLwmeVIpJbHrvEGU0cTBwqxT/AAy+9F94voeZ53wXXoXlS/q011iv6kV5x6+hWM0xKlEu8h4hlGa1u6l3fI29PP1sk77fI8No1Gnzfn5Gr4fx75N+r5lEysJ3xnrWAzFTa39C/hI8xy/OPDqxT31W5dD0HB19UU11GTKNFgmOTAxkd1BEoNch42ftJeRMoUpSey9eiK6qtTk10k18bEssqQE1YyoisxjsWLTa2K7Gp9Tmk+FoeSirwbkTsMlFW69Qcqe/d8y14Zyt1Ja5cr3HwoT5MvqWGUZS52lJbdENxqUaso9jYUKCirGS4lp6azf4kn9C+T/Jy/HdzA3Qiu8fzEc9nbqbQQhIJxnRHByCY4cHWFYNAGtDWgjQyRgorM4xCp05O9tmeTY9vEVr3ehPZcr9n8zf8ZVm46Fyf8GWyfAf1I33Ss38ESbLJcNRkGBVGkorm/al/wAn/lvQm10cw4dU7i+Q+GU2JpdQVNIt8Thymze0KNSbdlCEp35W0q4yRpeCuzzgvD4pOaWiq/8A2U0k2/7lykefZnw1isFLU466S/8AbTTaS/ujzj+hvMFxbGUIQpxcqtTTGEUrtyfNtdIpJts2MaWqK1pXa3S3V+xRSa8k+Xw8c4ezCMqq1c3bc9ay2utKS7FBnXBNCcnUpf0qnPVDaLfnHl8g2UYatQg/GnF6b2te2ldXfkUjIpukumro1NUowju5dui6t+RYwwV6kYX2S1Tfl0XqB4dw971Hzsktrc939C5wkd5y7yt6Lb9ypyTyyZBzLCNONXxJRhRjK1KDlFTqP3XKz3Xk7mcwtaz/AFNXmquox7tt+n/ZRYvBKzlH3l0/Ev3ITjb4XwzuKUhs9Nr9SqxUXJ+RIVbYiVq5BnTCLTAqlv5vZepuskwip00rb2M5w9gfEnrl7sfzZsG7LbouR04Vyzj+VO5UvQS5ks8fiVZdl7K9CzwbxrrSlU8DwH7sYxkqkee7lez6dCkxqepvrdhyeBfjr7EH7AuwgvivuIjw7emraOD2NsE4zg5CsIwTohHBgHWDmObGSA2FGezrB6typwuH0P0sajGrYoKq9o5Zvp0w8E3DlhSWxXYdkuFX9x4isJVSMH/qXjlHDqhH3q8rNdfDW8vovU0WeZ5Cit95P3ILnJ/RLqzzx5fUxNZ1sRd3d2+UHFcox6pIoml0Vxb4M4OwElVVR3VlaK22T72PVMFB2VykyHKtPtabK3sq1tjSqnaIFcnbC0oqkV2Or9Ol+l7g6tBzw9SH3p6Va6926uvlcLVpyepLZJrblqT3d2EhUULJWv6P1t8jpXDkfTSZIv6X/wBu/wAkT6Gyt2lL8239TP5VjtEvDk1adrNPaM+z+P0LWpV0vV0+8uy/EMI0dzCW8X0s16kWolZsmztJWfJldisM/utW82xWmuopjkvD4UWPtFNkPBYWVSV7fBFtWwKbvOV+yXJfuGwyUPdTb8iGjb6dcs31qJbZdh1CKiuf1CYjFqPNldLEVZbX0r5sHGgr3d5P+7f8jp76RyrC31hKmY1J7U7278l8ytqrdqXMtUV2b0XbXHp7y8u4k4urOiEFHiIuhCIH2xnSGyLaM27G2HCKnENFY7YRqMcExMa2BhOMHIc2NYjGRFxMdijxVOzNFONyBisNchOJaEqKynIbicTohKbvtZJLeUpN7JebdkGVOwR009P9rur9+4RrM9DJ3J+NWSlVqJao31eGukI+W758+ZbYHKIrolFcorl/Ja06XUkwgPVi7A6VGwZxHJHbDpClXjMHJ3ak+XLlYhRwu95qXon9DQaROI1i6optEdlG6ttykm/N3RIrZ6oJRk25Jc4JO/x6XD1qKZV4vApiSm14GWOL8hMuzZyk4xcordqLd7/sWPiN82/mzLTouElJc0+ZfYLEqcb9VzXZj4cm3H5HcIrwiah6YGLHpnSAKmduDTOpmMETOg7nUzAGfZKf4I/JCCXECkayxENOkTnOnDqI+LxCgrsz4ZdFXrJA1WTMtjc3cptRfLa/MnYOs7bsk5FdC6dU4qhXeMEp1Ce9j6ljFj5UyLTqEmnUKKmTaZEr4O5Bnh3Fl/zBzophcPwKn+lLTr25kmFdMLXwaZBqYVrkJTRRUydGY9MrIzkugenie9zbG1Jo1jI1l3E5ozYKFIj1Ih2wbQrCisxVG5XUpunO69V3Rd1YFbiqQl07Q6LOlVTSa5MKmU2Ar6XpfJ/ky1Ujvxz3VgDpjrgVI7qHFCahykB1HVIxguo6C1CMYtUxyBJj1IhE52cr1VFOT6GI4jzraW/wV+pZ8RZpZNL082YWvTnWqRtvqdkhZuykFRLyihrkna7bu272NdRp2QHKsv8ADgk7avJbIneGQZVDEgtMYwevcyRmWNIkxZDoz6dSVTKomw0JD1MCkOuOmLQXUDnBMY2LUBsyQOVIDPDk6mrj6sUkDX2HenRQ4qGkDKtbe5Y46CszG1pTVea1Nx9nTHpFW/7OebaOjGtjT0q9w2sgYKOyJjRkCR1yB1KWpXXMBXnbqNynG603s1drYHsWn5IuIpWZLwte635oNjKae6K6D0yKYp6yCnZaKR3UR4yHajts1BlIcpEdSHKRrBQbUIDqOmMXUZEXMcWoRYTUZjiLF+1pvy5/AhZNRtlFmuKdWrpV+lvU0uRZOqcVKS9trtyXYicMZVqbrzW/3E/1NNNi1ywt9pAnE447DluwrQtWGyvnErM2xypRvtqk1CCbtqm+V326vyReVlZHnOc45VsdGklGUad42km4uT957crLYGoVI3OVu0bXu93KX4pdWXOH5FDksduVunojQUEPEWYSwxoOkMkijRNMBJgpSHV3YEncQrEkU6tgdbEihEx/H+dSw8KdOj/vV56Yvnpit5St8l6glKkGMFKVF/icSVjgnO/WxA4fy+rGHiValSpOau9b2XwXQvMHhHzZzytstSiEw0OhIryUV5kqlTSVypxFdNyb6OyHqkTX2ZR8Q4uahPS7TcWodlJr2fzFwvB0qUYS5x2+I3D0XXrOT/26b2/ul/BZfZ7O65GUeWdE40qLOW6K+vAk0JvkdqwEfTm8EShU6dguoj1FZ3EpnVinaGJOocpEZSHqRUwfUIFqEExcOexj8Z/VxSprk5e18LmqlLYzWQR1Ymc+1+fmzmYi4ma2lFRikuSVkDnI7ORG1bhkxIoLrHwkApu7/wA5FHxnxVDA0r7SrTTVKn3f4pdooMUaToDx3xNHD0/Bpu+Iqq0UvuJ7amZ7hfLrxVR6vEm1ZOzW++rkZXKsLVxdWpXqS1Sc03Uk+T52Xlbax6xw/lrSU5Le1ortH92LLrpBhxWy4y3DaYpdkW1OIGhTsSYIpFCSZ1g5BJA5jsVEWuRdduZMqIj1qV0RLI46xkc8wSr4ylOXKlFqK827t/kjQSw1R7Jq3dhMHlai9Uval3fT4E5JyLRkodD4el7K26Bo0+wVROVp6Y36vkNr7I3ZHx2IUI2+80ZXE1m5eHF+3Ll5d2WmZTstUn3bA8P5fvKvNWlUd1fpD7q+QtbOjqxpRjbJuAwap01FdEOqRsviTpIiVN5eS/UfJSQjnYyEArgOpwDaSKRJlZXpEGasXlSmV+JojxersKZDUh6kRW7Ow6MzqTHJWsRH1iCai8k9ij4fpONWrdcpNL4X2L1IDTw9puS68zn/AAknxkmowNwskMdK5vYpV43MZxvChTc6j21S9mnDtd838EvkYTN+F61Ws3UnKpVqVIKdVpWjHTfSl0S7fE9SpYRLcNDCRve276mtmdGU4Y4XVGKi90nffq+7NnQopI7Tph0hoxoEpWOih6Q1HblUSZ1gpD2wcmZhiCkMHTGEJeSqO2OxOXFcyZhxAzHEWduxMlPZsyeb4xynoh70npX7mk/RTFDZndTr1dK/24tOT/FLmoo00KelW67bEHLKaoU1ZLxH1aTt3du4ZSfN/wDYySii03fF4QStV0/F8iPCPzfMeo3d3z/QLCBCT2ZKwlGAXSdhGw4pFcJtgZwIlaBPkRq4JIyZm8yjpkn3+hFVQkcR11CMW/xP9DLVcfKe0dkPCaUelk+F/wDa49xGd0vuxG/qaz0xBECjIJFioi0OSCxQG4+MjAoMhyYJSHqQUag6Y9SAKZ1SKJi0SExOQFSO6g2Ch7YOUjkpAnIDYUhzYxs42cciTHO6hOQPUBxNbSrvklcXajUCzbFqnTlJuySbb7IzvDsHNyxEvv7U01uod/X9iLmTq4+r4FK6w8JJ1qj5Ttv4ce/n8u5qsHgVTiororeSXkNHr2Lp6Rr2x8Yhox7nVGw9I0nZJys5GJIhAHFBogihWx1hsmOGSZRijJyImImGqyKjMMVpTfy+JCcqGirMlxdiddaNNcqau/8AlL+EvmV+Hpj8ZQam5S31Nu/mwlFCplqCeGIJY6awGvoYi5LhVMDw/wAQKcVd72XU1OHxia2ZVMFFypDkyuhiA0a4wupMUh6kRFVHKoEFEvWd1kZVBeIGzUSlM74hE8QXiA2NqSXUGSmA8Q5rFbNQZzG6geo5cVhDJgq9FTVmJMepCtWA7h6MYqySXwQRsE5jdYyYPIVjkwKmdUjGJEWPUiOpndY6AHcwc5jHMDVqmbCkMxVXYz2Nq6pW6InY/E7bcyrRyTlbKxVAKtFSTTKudJwduncvNIKvQugJjFTqYiT9kYh7NR5XlOOlCSV+fJm2yzPXGyb3/NfujzynKyV1ylf0fNF9g6sXZSe21n2ReaExvh6Xg83UlzLGli+tyjwWS+xGaldSSafR+T/z+ZlPDyjsDvsa0XVPFEiNcpYNhI1GhgFwqw7xiqjXCqqA1E/xheKQlIJFgNRJ8Q6pgUPiAAZTO6wR0wAqmO1ke525jB3M5cCmOuAFBkxyYFTGuoMjEjUccyJKuBqYo10CibOtYgYrF2ImJxtiFrb3fouxDJk9IrGAWc23dnYoZFBoQIoZiUR1gkYhfDKpC2RvCRwk6BDUA8A6P4r6FlQ5CEdLBA9b4d/8fD/gyXV6CEB+RUBZxiEAYXUPAQjBCwDxEIBmFQ5HRBAdOsQgCnDh0QAnBCEAwgczggmI9UjVBCEkPEra3vL4hVzEI5WVJUQ8eQhDomwsAqOiKoQQhCCY/9k=","100000"},
            {"Peeling", "Peeling adalah treatment yang sangat baik untuk kesehatan kulit Dengan melakukan peeling maka kulit akan menjadi cerah seketika", "data:image/jpeg;base64,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","100000"},
            {"Peeling", "Peeling adalah treatment yang sangat baik untuk kesehatan kulit Dengan melakukan peeling maka kulit akan menjadi cerah seketika", "data:image/jpeg;base64,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","100000"},
            {"Peeling", "Peeling adalah treatment yang sangat baik untuk kesehatan kulit Dengan melakukan peeling maka kulit akan menjadi cerah seketika", "data:image/jpeg;base64,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","100000"},
    };

    public static ArrayList<TreatmentModel> getListData(){
        TreatmentModel treatmentModel = null;
        ArrayList<TreatmentModel> list = new ArrayList<>();

        for (int i = 0; i < data.length;  i++) {
            treatmentModel = new TreatmentModel();
            treatmentModel.setNamaTreatment(data[i][0]);
            treatmentModel.setDetailTreatment(data[i][1]);
            treatmentModel.setImage_url(data[i][2]);
            treatmentModel.setHargaTreatment(Integer.parseInt(data[i][3]));
            treatmentModel.setIndex(i);

            list.add(treatmentModel);

        }
        return list;
    }
}
