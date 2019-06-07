package jgit;

import com.jcraft.jsch.Session;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.Transport;

import java.io.File;

public class JGitTest {

    public static void main(String[] args) throws GitAPIException {
        long beg = System.currentTimeMillis();
        //ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC/sS1V9Op2C23xjZnfcoO1D3JbR1nav3yMvA64ROLyF0i95hN3hfX+CN3lnE6dKvrz+umd5rNqgw8gWrkMb9lNhJ5kjt016Um6I7ht9Dhi94Okk1YUe7JUy4dhYq3x9JH/POG3Ax0+YJC6sN7qGFE3NzREGZOXX84WauQfVr3U0Q3bbMmY8c5srfIVbxKEnPDbiZyzo4/X/IZNTy5RU3jHDwXN7sRPuhP+mP8ik6iDkTgcB0ryO1T3fVbTc6ZS2EmDRqLR/Ynxb/yt0wlH9ctZNvNKk8AieqScucEkf+wQ9NsCCW1WMpVPZjsNuIrBlQwFZoK3Kh4wDDW+85yZaap/ zhaojun5@jd.com
        //git@git.jd.com:pop-rd-man/pop-advisory-center.git
        //http://git.jd.com/pop-rd-man/pop-advisory-center.git

        /*UsernamePasswordCredentialsProvider usernamePasswordCredentialsProvider =new
                UsernamePasswordCredentialsProvider("AAAAB3NzaC1yc2EAAAADAQABAAABAQC/sS1V9Op2C23xjZnfcoO1D3JbR1nav3yMvA64ROLyF0i95hN3hfX+CN3lnE6dKvrz+umd5rNqgw8gWrkMb9lNhJ5kjt016Um6I7ht9Dhi94Okk1YUe7JUy4dhYq3x9JH/POG3Ax0+YJC6sN7qGFE3NzREGZOXX84WauQfVr3U0Q3bbMmY8c5srfIVbxKEnPDbiZyzo4/X/IZNTy5RU3jHDwXN7sRPuhP+mP8ik6iDkTgcB0ryO1T3fVbTc6ZS2EmDRqLR/Ynxb/yt0wlH9ctZNvNKk8AieqScucEkf+wQ9NsCCW1WMpVPZjsNuIrBlQwFZoK3Kh4wDDW+85yZaap/","");

        Git.cloneRepository().setURI("http://git.jd.com/pop-rd-man/pop-advisory-center.git")
                .setDirectory(new File("/Users/zhaojun5/work/testtest"))
                .setCredentialsProvider(usernamePasswordCredentialsProvider).call();
        long end = System.currentTimeMillis();
        System.out.println("下载git项目耗时：" + (end - beg) + "ms");*/

        /*final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
            @Override
            protected void configure(OpenSshConfig.Host host, Session session ) {
                // do nothing
            }
        };*/
        String appName = "pop-advisory-center";
        CloneCommand cloneCommand = Git.cloneRepository();
        cloneCommand.setURI( "git@git.jd.com:pop-rd-man/pop-advisory-center.git" );
        cloneCommand.setTransportConfigCallback( new TransportConfigCallback() {
            @Override
            public void configure( Transport transport ) {
                SshTransport sshTransport = ( SshTransport )transport;
                sshTransport.setSshSessionFactory(new JschConfigSessionFactory() {
                    @Override
                    protected void configure(OpenSshConfig.Host host, Session session ) {
                        // do nothing
                    }
                } );
            }
        } );
        cloneCommand.setDirectory(new File("/Users/zhaojun5/work/"+appName)).call();

        System.out.println((System.currentTimeMillis() - beg));




    }
}

