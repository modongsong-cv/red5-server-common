package org.red5.server.net.rtmp.codec;

import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.red5.io.utils.IOUtils;
import org.red5.server.net.protocol.RTMPDecodeState;
import org.red5.server.net.rtmp.IRTMPHandler;
import org.red5.server.net.rtmp.RTMPConnection;
import org.red5.server.net.rtmp.RTMPMinaConnection;
import org.red5.server.net.rtmp.event.Invoke;
import org.red5.server.net.rtmp.message.Header;
import org.red5.server.net.rtmp.message.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRTMPProtocolDecoder implements IRTMPHandler {

    protected Logger log = LoggerFactory.getLogger(TestRTMPProtocolDecoder.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDecodeBuffer() {
        log.debug("\ntestDecodeBuffer");
        RTMPProtocolDecoder dec = new RTMPProtocolDecoder();
        List<Object> objs;
        RTMPConnection conn = new RTMPMinaConnection();
        conn.getState().setState(RTMP.STATE_CONNECTED);
        conn.setHandler(this);
        IoBuffer p00 = IoBuffer
                .wrap(IOUtils
                        .hexStringToByteArray("8639ae8685ad4e802fb905a7918b480416b013e0632e41773e6ba30a1ee089ddb94df6eff6b59aa6251a2707215a2907dc6b51a749ff6680b37792b6c302d43e80f4780361ab7b3c79de5f917aece673e6192e0d45606a5a56dc23ee8113b3381a5d428074f461db71f8caaefa650517809b63edc8412c1f88b4e4d43584ca491a89dfdbb78df1b00c1cedc8e2139fe831becd70527adf4d17760c1cbfff47a1116aaa8f603d3f5319a0688bbc215c1cae1cfb06b6546abd4b76cc7f32cbc84b4531ba2f539d6ae5c4c081bcc51a73b7c14881f8b6bddb480d8a4430b98577f15d31215480d6ebb9cb56931ad3703c2bf024c943b3c45c18717d467387141cdcc88f389548bc335b10ead0daf8e8c69e67f43099ab1f5f2afcb343c08d4b065ec7ce3a437d9891ec8388155d5bdae8dcfd6b4419df2d9c7ca584511e240cc6b1f04ccc098a74d5037c921e4f5916affa17ff71daed20d621687b12bd3f7fcb8f538360b39eb237ca05ada13dc433dc10c2504c55e5ca2e6528b3279eb49e4629218acfc33fce315c58533076d7e3fff6e49650d4283c8fa4ee766f93fc3d10b10bd10b8c2393e2a1da4e6c53dcc5ddbd6efd7b844b7546b0472346b9229cdb6e8d45f70f1e6d23b96cbb2c41fcd486e25fef021e19568c4617248e58ca195fb7aad5ca34dcf27ac7f03dc71a8b4831d1bbb273f6bba56ed9cdf49eef6c45df5071d19d9e8e23fb33b34a65648141cd61db72f79fa7944e3232cd8e30ba310d566fdac6d51b683a3c27af315ca5dc0f614d62c6672e97c036d181e00d6cf08b41a130d7a24783ad616593dc10753959529657f94aec63fa073ae24afe44b2d7075164ebc25305db954607b92c1c7ded5f88e587227ce411010292b6e392aeaeca456d64dadec73cac5de51ec2d3b530db0cdb9869fbdabe1f0aae10bcc1479dc927178a323ac0b2c1def11a086605ee0a66d5a9f1652b5b5860cdbd3594c8e2511c004d8704ccb2732197f37e687753ce0ed00717f20ca6e7076fd4d06b49ba8c665a2adc41e702753225868ace398baebb6944c29c149b838fb71b1e8c20ed3c9561129867c56bc800be10f8dba659f37bbe2242b0cbdcf342396e5ee61f327e7759500d4647e313937c81809b602af08493812ca199698ed35de9ebeded83e1ef5d8f8ad56c368acd7a6d7a05118541bf9d60bc3e45d64431a7700770c814f48f5dcd1c35270a5288b8cbde9333b5b8c40dfd6f0d31d51bea52e0bc6e6e4f46b1bfe85268a494a83d20668829dcfa492325e5f372f45a74bc19c9be07eda5bb1060376b0563081f541801b7d7ce5f7408e5bb11f63d0638419f7cb8aaaa55afa32dfb1e4f0df11fc355ad6c30405b8824f8fff87feeb3b5390cde76040008bb422200a571cd0c19fda9df620ad6ca881c833728081e7cefecc78b280cc06b4c7de3d1c9cebc04d84e1c43fb9fc8b52cc07e0eb15012872c0739322b1da9d7888b6c0f968863ac571837fd63457f98d574665e3cbe1f3b497fb03d1ab8e481985732de26051919d0aba7f18281d8f512b05a625746e4dd50e0c4be16ab4b59aa3cf24e1648ee9d74e4f3b2a92fc7828a5eb2040a706d52e354fb079df3062d404c46fb78de4931caac381020c5bf6b38fecdc5f7d66c3ea3fb087f4ed8ac98a81a24a42053282c7524c2953a5885c1ff5d736d46c472d318312f2a427dc3526fd513c88dbb8583d607031c0a2825f9e74428b859d8874e0cb013b458b27d549a41e4330682dac90e073b79c458dcb2cba317f816bd2dabdcee96d77ab6466021a23a932d134ba33279956aae938787a3a59216b53d50dc0554fe34b5f51d1e050f84e03a7442b29604684291a2ee79198a3911f8a54a1e47c0bf9ec25114f60dae43d4aa4639e5a5c89010ba3884014c2721cab878795f22ba8136f7d4685c9a5c348bda08b60a1ff1afe6d5578d52f5051eeafa9e3b9501701a272a880aaeb30fbc2db66a5e48d7c811a56c9a809c92567d8a10472c142f3dc38c0123e20ed3feb067a550e0a997b38061e191a3bb5b47a04ef70fdd94e69bfc9be160d8a8cc7dc163e8d595cc987c1d676a7b543f56305be60921c19113be5ea988c864b636e216c1c6d71319e0c96b58eb619ac63016ffb97761b79a3eea0016cfacadc7c10300000100014d1400000000020007636f6e6e656374003ff0000000000000030003617070020003766f640008666c61736856657202000e4c4e582032302c302c302c323836000673776655726c020036687474703a2f2f6c6f63616c686f73743a353038302f766f642f6d696e69706c617965722e7377662f5b5b44594e414d49435d5d2f320005746355c3726c02001972746d703a2f2f6c6f63616c686f73743a313933352f766f640004667061640100000c6361706162696c697469657300406de00000000000000b617564696f436f646563730040abee0000000000000b766964656f436f6465637300406f800000000000000d766964656f46756e6374696f6e003ff00000000000c30000077061676555726c020024687474703a2f2f6c6f63616c686f73743a353038302f766f642f696e6465782e68746d6c000e6f626a656374456e636f64696e67004008000000000000000009"));
        p00.position(1536);
        objs = dec.decodeBuffer(conn, p00);
        log.debug("Objects #00: {}", objs);
        assertNotNull("Objects should not be null", objs);
        assertFalse("Objects should not be empty", objs.isEmpty());
        assertEquals("Method should be 'connect'", "connect",  ((Invoke)((Packet)objs.get(0)).getMessage()).getCall().getServiceMethodName());

        IoBuffer p01 = IoBuffer.wrap(IOUtils.hexStringToByteArray("030000000001431400000000020007636f6e6e656374003ff0000000000000030003617070020003766f640008666c61736856657202000e4c4e582032302c302c302c323836000673776655726c020036687474703a2f2f6c6f63616c686f73743a353038302f766f642f6d696e69706c617965722e7377662f5b5b44594e414d49435d5d2f320005746355c3726c02001972746d703a2f2f6c6f63616c686f73743a313933352f766f640004667061640100000c6361706162696c697469657300406de00000000000000b617564696f436f646563730040abee0000000000000b766964656f436f6465637300406f800000000000000d766964656f46756e6374696f6e003ff00000000000c30000077061676555726c02001a687474703a2f2f6c6f63616c686f73743a353038302f766f642f000e6f626a656374456e636f64696e6700400800000000000000000902fffe410000040500000000009896800300003100001a11000000000002000c63726561746553747265616d00400000000000000005"));
        objs = dec.decodeBuffer(conn, p01);
        log.debug("Objects #01: {}", objs);
    }

    @Test
    public void testDecodeBufferCreateDelete() {
        log.debug("\ntestDecodeBufferCreateDelete");
        RTMPProtocolDecoder dec = new RTMPProtocolDecoder();
        List<Object> objs;
        RTMPConnection conn = new RTMPMinaConnection();
        conn.getState().setState(RTMP.STATE_CONNECTED);
        conn.setHandler(this);
        conn.getState().setLastReadHeader(2, new Header()); //TODO hardcoded, so test will not fail
        conn.getState().setLastReadHeader(3, new Header()); //TODO hardcoded, so test will not fail
        conn.getState().setLastReadHeader(4, new Header()); //TODO hardcoded, so test will not fail
        int idx = 0;
        for (IoBuffer p : new IoBuffer[] {
                IoBuffer.wrap(IOUtils.hexStringToByteArray("4300120c0000191402000c63726561746553747265616d00400800000000000005"))
                , IoBuffer.wrap(IOUtils.hexStringToByteArray("4200000000000a0400030000000000001388830014d302000c63726561746553747265616d0040100000000"
                        + "0000005430000000000221402000c64656c65746553747265616d00000000000000000005003ff0000000000000"))
                , IoBuffer.wrap(IOUtils.hexStringToByteArray("04007dc400010108010000006a42a5b3b597d08decc518618c31c688880821841022226eaaaaaaaaaafeff"
                        + "ffffffffffffffffffe17384c5790bb1ae48f4812ff082e31ce7381ccecffdfdff7f16a61525c7586c145624279c6d15b8ca145c5b11a396dc1ea405aa"
                        + "eb584a82022a4aab5c0d3ccf732381d8568f05399f98b47eb22b1a714aa116482deab090420000000000040100000101c4e3d6aed29dc420b24cd22897"
                        + "948f0d68c12e16b640bc736918d278b5956c2d44e358010e8ff699b91bd73716ecd70b891b3791263b9d380554dccec61646ad51dd5e9ed429a3a4a2b0"
                        + "51066394111179fbe53f6562f3f461cd49fb1b6b662e79535391f32d29668e3494a211ff442e2de649475ba8e480f6de4ef5b73dff6d3356"))
                })
        {
            objs = dec.decodeBuffer(conn, p);
            log.debug("Objects #02: {}", objs);
            assertFalse("Objects should not be empty", objs.isEmpty());
            assertEquals("Buffer should be empty [idx = " + idx++ + "]", p.capacity(), p.remaining());
        }
    }

    @Test
    public void testDecodePacket() {
        log.debug("\ntestDecodePacket");
        RTMPConnection conn = new RTMPMinaConnection();
        RTMPDecodeState state = new RTMPDecodeState("junit");

        List<IoBuffer> bufferList = new LinkedList<>();
        // packet #0 // connect // 320
        bufferList.add(IoBuffer.wrap(IOUtils
                        .hexStringToByteArray("030000000001321400000000020007636f6e6e656374003ff00000000000000300036170700200086f666c6144656d6f0008666c61736856657202000e4c4e582032302c302c302c333036000673776655726c020029687474703a2f2f6c6f63616c686f73743a353038302f64656d6f732f6f666c615f64656d6f2e7377660005746355726c02001972746dc3703a2f2f6c6f63616c686f73742f6f666c6144656d6f0004667061640100000c6361706162696c697469657300406de00000000000000b617564696f436f646563730040abee0000000000000b766964656f436f6465637300406f800000000000000d766964656f46756e6374696f6e003ff000000000000000077061676555c3726c02002a687474703a2f2f6c6f63616c686f73743a353038302f64656d6f732f6f666c615f64656d6f2e68746d6c000009")));
        // packet #1 // 16
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("02db5565000004050000000000989680")));
        // packet #2 // 59
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("0300017c00002f140000000002002264656d6f536572766963652e6765744c6973744f66417661696c61626c65464c567300400000000000000005")));
        // packet #3  // 14
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("42000000000006040007ce4c5f73")));
        // packet #4 // 7
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("c20007ce4c6743")));
        // packet #5 // 7
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("c20007ce4c6f13")));
        // packet #6 // 33
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("43001e610000191402000c63726561746553747265616d00400800000000000005")));
        // packet #7 // 18
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("4200000000000a0400030000000000001388")));
        // packet #8 // 52
        bufferList.add(IoBuffer.wrap(IOUtils.hexStringToByteArray("08001fdd00001d1401000000020004706c61790000000000000000000502000973706565782e666c76c200030000000100001388")));
        // packet #9 // huge connect from OpenMeetings
        bufferList.add(IoBuffer.wrap(IOUtils
        		.hexStringToByteArray("030000000001b71400000000020007636f6e6e656374003ff000000000000003000361707002000e6f70656e6d656574696e67732f350008666c61736856657202000e4c4e582032302c302c302c323836000673776655726c020082687474703a2f2f6c6f63616c686f73743a353038302f6f70656e6d656574696e67732f7075626c69632f6d61696e6465c36275672e73776631312e7377663f7769636b65747369643d3563333562613330396634393030346139303366323264623663323564393330266c616e67756167653d31267769636b6574726f6f6d69643d350005746355726c02002472746d703a2f2f6c6f63616c686f73743a313933352f6f70656e6d656574696e67732f35c30004667061640100000c6361706162696c697469657300406de00000000000000b617564696f436f646563730040abee0000000000000b766964656f436f6465637300406f800000000000000d766964656f46756e6374696f6e003ff000000000000000077061676555726c02002a687474703a2f2f6c6f63616c686f73743ac3353038302f6f70656e6d656574696e67732f23726f6f6d2f35000e6f626a656374456e636f64696e670040080000000000000000090100")));
        // packet #10 // huge packet from openmeetings room video start
        bufferList.add(IoBuffer.wrap(IOUtils
        		.hexStringToByteArray("0400833600010108010000006a009d1556ebe4530aaa09618c31c6a8db86b8214288888888db5455bfaafeffffffffffffffffff03ef52c4ae65987b86e03da017f3c0e3cee1781ec3ffffff9fa8b0ae65b85f811331b8a693329508a7d355959c4573e2fb5a76c9ee8bc829940aeed79bfe67f80969ecb41dca2c6f470d81b2aef60e46de4c4296f15a52f1420000000000040100000101c4bd68616f2fc917a913b5b6de8c4e1189533d5c755f725987341ac5da4b17d2d6629c293bd6100204ed2625389b8d52de42456a37f7792593a505955736d359c6f66852b242c8dbb84fb996a48bf31898288ee1342bf7341d0b5c1516c6d80a4b8d9e243fea93b38d3a226b94aace757de91d4c8278c7ae37fdd69668d9ad75e03a840000416a283256ab9b61c017b1c7586c3415484def32c7ce4323c5eb5fead89923959649d3c69e3ad0591a707ac3b049cd90722af8b597cdee6f5c1ad3a886961a9d6011262337c7c655a916a9a6a09b908d5852a85abd9dcda890194fdd881579b26b456ad572bc6d3fa0a15d39c910f3d6b91075bdd899f64bdc706a4b7031bd36936568593243b99bb07729b7209b3311a8435a69ba82eb49d5c448a033715eecaa340a")));
        
        int i = 0;
        RTMPProtocolDecoder dec = new RTMPProtocolDecoder();
        for (IoBuffer buf : bufferList) {
            Packet pkt = dec.decodePacket(conn, state, buf);
            log.debug("Packet #{}: {}\nstate: {}", i, pkt, state);
            i++;
            assertNotNull("Decoded packet should not be NULL", pkt);
        }

    }

	@Override
	public void connectionOpened(RTMPConnection conn) {
		// TODO Auto-generated method stub
	}

	@Override
	public void messageReceived(RTMPConnection conn, Packet packet) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void messageSent(RTMPConnection conn, Packet packet) {
		// TODO Auto-generated method stub
	}

	@Override
	public void connectionClosed(RTMPConnection conn) {
		// TODO Auto-generated method stub
	}

//    @Test
//    public void testDecodeMessage() {
//        log.debug("\ntestDecodeMessage");
//        log.debug("Not yet implemented");
//    }
//
//    @Test
//    public void testDecodeInvoke() {
//        log.debug("\ntestDecodeInvoke");
//        log.debug("Not yet implemented");
//    }

}
