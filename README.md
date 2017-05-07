# memcachedExample

在Ubuntu下直接使用如下命令进行安装即可：
sudo apt-get install memcached
由于memcached依赖于libevent；因此，还需要安装libevent,命令如下：
sudo apt-get install libevent-dev

命令如下：
./memcached -m 512 -p 11211 -vv
该命令后面参数的含义为：分配给memcached的可用内存512M，监听11211端口，显示详细的运行信息。
这里要注意的是：需要切换到memcached的安装目录下运行此命令才有效。 方法为：which memcached 即可查找出memcached的安装目录。

切换到“/usr/bin”下然后执行命令./memcached -m 512 -p 11211 -vv即可启动了。
11211是默认端口，可以修改
