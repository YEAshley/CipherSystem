# CipherSystem  
①首先在IntelliJ IDEA中编写所有的加解密算法以及实现DH密钥交换过程，此部分为单机加解密系统的后端部分，由小组三人共同完成，本人完成的算法为：Vigenere、Playfair 、DES、Permutation 、Column permutation。
②在JavaFX Scene Builder中设计界面，可以从主菜单界面选择进入单机加解密、双机--加密端或双机--解密端。单机加解密系统主要用于字符串加解密和文件加解密，界面中“加密算法”的下拉框中罗列了15中算法，如RSA、CA、DH等在用户点击之后还可以跳转至新界面进行相关操作。双机--加密端和双机--解密端则需要配合使用，利用加密端提供IP地址（后端已经统一端口号）实现连接，加密端可以选择加密算法并输入密钥对明文进行加密，通过Socket通信将算法、密文和密钥传递给解密方，然后再由解密方进行解密操作。除此之外，对于更为复杂的DH密钥交换过程，客户端和服务器之间还可以进行额外的通信。
③将编写完的后端算法封装好，便于从前端直接调用。
④双机加解密系统实现过程中，所有的算法仍然是直接调用，但是需要将加密功能和解密功能分开到两个不同的controller类中（实现单机时，通过单选按钮选择加密还是解密模式），才能在两端显示。
  
 下面是软件运行界面截图  
![图片1](https://user-images.githubusercontent.com/62821148/163166630-b53612a4-024f-4cc4-b35e-1d05306ae4b3.png)
![图片2](https://user-images.githubusercontent.com/62821148/163166604-3addcfab-72be-44d3-a23c-9161cb8a4dcb.png)
![图片3](https://user-images.githubusercontent.com/62821148/163166615-39caee35-e3dd-4a77-9c40-0aab684f168b.png)
![图片4](https://user-images.githubusercontent.com/62821148/163166618-23fee5dd-459f-4376-be26-8f30f0d54a22.png)
![图片5](https://user-images.githubusercontent.com/62821148/163166622-da27de87-fdd5-4973-bfce-c80c9e8eb94c.png)
![图片6](https://user-images.githubusercontent.com/62821148/163166624-b1223c7e-fab4-4d73-878b-c788813da27d.png)
![图片7](https://user-images.githubusercontent.com/62821148/163166625-51fe5b5d-56a9-4be6-92fd-3341bbc3e627.png)
![图片8](https://user-images.githubusercontent.com/62821148/163166628-a93790b5-1140-483a-921a-cd3a1e6ab59f.png)
