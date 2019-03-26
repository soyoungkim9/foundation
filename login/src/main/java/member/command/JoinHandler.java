package member.command;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JoinHandler implements CommandHandler {

    private static final String FORM_VIEW = "/WEB_INF/view/joinForm.jsp";
    private JoinService joinService = new JoinService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        if(req.getMethod().equalsIgnoreCase("GET")) {
            return processForm(req, res);
        } else if(req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null;
        }
    }
    private String processForm(HttpServletRequest req, HttpServletResponse res) {
        return FORM_VIEW;
    }

    private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
        JoinRequest joinReq = new JoinRequest();
        joinReq.setId(req.getParameter("id"));
        joinReq.setId(req.getParameter("name"));
        joinReq.setId(req.getParameter("pwd"));
        joinReq.setId(req.getParameter("confirmPwd"));

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);

        joinReq.validate(errors);

        if(!errors.isEmpty()) {
            return FORM_VIEW;
        }

        try {
            joinService.join(joinReq);
            return "/WEB-INF/joinSuccess.jsp";
        } catch (DuplicateIdException e) {
            errors.put("duplicateId", Boolean.TRUE);
            return FORM_VIEW;
        }
    }
}
