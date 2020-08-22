package handling.channel.handler;

import java.util.List;
import client.MapleClient;
import handling.MaplePacket;
import server.movement.LifeMovementFragment;
import tools.packet.MaplePacketCreator;
import tools.data.input.SeekableLittleEndianAccessor;

public class MovePlayerHandler extends AbstractMovementPacketHandler {

    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MovePlayerHandler.class);

    @Override
    public void handlePacket(SeekableLittleEndianAccessor slea, MapleClient c) {
        log.info("MovePlayerHandler.handlePacket c.getPlayer().getPosition():{}", new Object[] {c.getPlayer().getPosition()});
        slea.readByte();
        slea.readInt();
        final List<LifeMovementFragment> res = parseMovement(slea);
        if (res != null) {
//            if (slea.available() != 18) {
//                log.warn("slea.available != 18 (movement parsing error)"); //dash problem?
//                return;
//            }
            if (!c.getPlayer().isHidden()) {
                MaplePacket packet = MaplePacketCreator.movePlayer(c.getPlayer().getId(), res);
                c.getPlayer().getMap().broadcastMessage(c.getPlayer(), packet, false);
            }
            updatePosition(res, c.getPlayer(), 0);
            log.info("c.getPlayer().getPosition():{}", new Object[] {c.getPlayer().getPosition()});
            c.getPlayer().getMap().movePlayer(c.getPlayer(), c.getPlayer().getPosition());
        }
    }
}
