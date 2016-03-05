package reference;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;

import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.util.concurrent.Executors;

/**
 * Netty ����˴���
 * 
 * @author lihzh
 * @alia OneCoder
 * @blog http://www.coderli.com
 */
public class HelloServer {

	public static void main(String args[]) {
		// Server����������
		ServerBootstrap bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));
		// ����һ������ͻ�����Ϣ�͸�����Ϣ�¼�����(Handler)
		bootstrap
				.setPipelineFactory(new ChannelPipelineFactory() {
					@Override
					public ChannelPipeline getPipeline()
							throws Exception {
						return Channels
								.pipeline(new HelloServerHandler());
					}
				});
		// ����8000�˿ڹ��ͻ��˷��ʡ�
		bootstrap.bind(new InetSocketAddress(8000));
	}

	private static class HelloServerHandler extends
			SimpleChannelHandler {

		/**
		 * ���пͻ��˰󶨵�����˵�ʱ�򴥷�����ӡ"Hello world, I'm server."
		 * 
		 * @alia OneCoder
		 * @author lihzh
		 */
		@Override
		public void channelConnected(
				ChannelHandlerContext ctx,
				ChannelStateEvent e) {
			System.out.println("Hello world, I'm server.");
		}
	}
}
ss HelloServer {

}
