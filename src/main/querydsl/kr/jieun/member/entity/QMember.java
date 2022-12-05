package kr.jieun.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -2077207001L;

    public static final QMember member = new QMember("member1");

    public final StringPath enabled = createString("enabled");

    public final StringPath id = createString("id");

    public final ListPath<kr.jieun.board.entity.Board, kr.jieun.board.entity.QBoard> listBoard = this.<kr.jieun.board.entity.Board, kr.jieun.board.entity.QBoard>createList("listBoard", kr.jieun.board.entity.Board.class, kr.jieun.board.entity.QBoard.class, PathInits.DIRECT2);

    public final ListPath<kr.jieun.reply.entity.Reply, kr.jieun.reply.entity.QReply> listReply = this.<kr.jieun.reply.entity.Reply, kr.jieun.reply.entity.QReply>createList("listReply", kr.jieun.reply.entity.Reply.class, kr.jieun.reply.entity.QReply.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

